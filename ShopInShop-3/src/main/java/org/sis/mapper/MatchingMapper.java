package org.sis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sis.board.model.MatchingAttachVO;
import org.sis.board.model.Criteria;
import org.sis.board.model.MatchingVO;

public interface MatchingMapper {

	
	public void insert(MatchingVO vo);	
	public MatchingVO select(Integer bno);
	
	public int delete(Integer bno);
	public int update(MatchingVO vo);

	public List<Integer> NextPrevBno(Integer bno); 

	public int selectPageCount(Criteria cri);	
	public List<MatchingVO> selectPage(Criteria cri);
	
	
	public List<MatchingVO> search(@Param("map") Map<String,String> map);
	
	@Update("update tbl_board_join set replycnt=replycnt+#{amount} where bno =#{bno}")
	public int updateReplyCnt(@Param("bno") Integer bno,@Param("amount") int amount);
	
	@Select("select * from tbl_board_join_file where bno = #{bno}")
	public List<MatchingAttachVO> findbyBno(int bno);
	
	@Update("update tbl_board_join set viewcnt=viewcnt+1 where bno =#{bno}")
	public int updateViewCnt(@Param("bno") Integer bno);
	
}