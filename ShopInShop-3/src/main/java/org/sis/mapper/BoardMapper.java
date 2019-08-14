package org.sis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.sis.board.model.BoardVO;
import org.sis.board.model.Criteria;

public interface BoardMapper {

	
	public void insert(BoardVO vo);
	
	
	public BoardVO select(Integer bno);

	public int update(BoardVO vo);

	@Delete("delete from tbl_board2 where bno=#{bno}")
	public int delete(Integer bno);
	
	
	public List<BoardVO> selectPage(Criteria cri);


	public int selectPageCount(Criteria cri);
	
	
	public List<BoardVO> search(@Param("map") Map<String,String> map);
	
	@Update("update tbl_board2 set replycnt=replycnt+#{amount} where bno =#{bno}")
	public int updateReplyCnt(@Param("bno") Integer bno,@Param("amount") int amount);
	
}