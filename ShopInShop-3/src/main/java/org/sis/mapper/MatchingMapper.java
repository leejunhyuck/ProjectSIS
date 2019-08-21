package org.sis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sis.board.test.model.BoardAttachVO;
import org.sis.board.test.model.Criteria;
import org.sis.board.test.model.MatchingVO;

public interface MatchingMapper {

	
	public void insert(MatchingVO vo);	
	public MatchingVO select(Integer bno);
	
	public int delete(Integer bno);
	public int update(MatchingVO vo);


	public int selectPageCount(Criteria cri);	
	public List<MatchingVO> selectPage(Criteria cri);
	
	
	public List<MatchingVO> search(@Param("map") Map<String,String> map);
	
	@Update("update tbl_board_matching set replycnt=replycnt+#{amount} where bno =#{bno}")
	public int updateReplyCnt(@Param("bno") Integer bno,@Param("amount") int amount);
	
	@Select("select * from tbl_attach where bno = #{bno}")
	public List<BoardAttachVO> findbyBno(int bno);
	
}