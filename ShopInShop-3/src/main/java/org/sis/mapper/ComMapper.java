package org.sis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sis.board.model.ComAttachVO;
import org.sis.board.model.Criteria;
import org.sis.board.model.ComVO;

public interface ComMapper {

	
	public void insert(ComVO vo);	
	public ComVO select(Integer bno);
	
	public int delete(Integer bno);
	public int update(ComVO vo);


	public int selectPageCount(Criteria cri);	
	public List<ComVO> selectPage(Criteria cri);
	
	
	public List<ComVO> search(@Param("map") Map<String,String> map);
	
	@Update("update tbl_board_com set replycnt=replycnt+#{amount} where bno =#{bno}")
	public int updateReplyCnt(@Param("bno") Integer bno,@Param("amount") int amount);
	
	@Select("select * from tbl_board_com_file where bno = #{bno}")
	public List<ComAttachVO> findbyBno(int bno);
	
}