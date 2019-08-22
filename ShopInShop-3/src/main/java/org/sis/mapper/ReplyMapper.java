package org.sis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sis.board.test.model.Criteria;
import org.sis.board.test.model.ReplyVO;

public interface ReplyMapper {
	
	@Insert("insert into tbl_reply (bno,reply,replyer) values(#{bno},#{reply},#{replyer})")
	public int insert(ReplyVO vo);
	
	@Select("select * from tbl_reply where bno=#{bno} order by rno asc")
	public List<ReplyVO> list(@Param("bno") Integer bno);
	
	@Select("select * from tbl_reply where bno=#{bno} order by rno asc limit #{skip} , 10")
	public List<ReplyVO> listPage(Criteria cri);
	
	@Select("select * from tbl_reply where rno=#{rno}")
	public ReplyVO select(@Param("rno")Integer rno);
	
	@Delete("delete from tbl_reply where rno=#{rno}")
	public int delete(@Param("rno") Integer rno);
	
	@Update("update tbl_reply set reply = #{reply} where rno = #{rno}")
	public int update(ReplyVO vo);
	
	@Select("select count(*) from tbl_reply where bno =#{bno}")
	public int CountReply(@Param("bno") Integer bno);
	
	
	@Insert("insert into tbl_s1 (col1) values (#{str})")
	public void insert1(@Param("str") String str);


	@Insert("insert into tbl_s2 (col1) values (#{str})")
	public void insert2(@Param("str") String str);

}