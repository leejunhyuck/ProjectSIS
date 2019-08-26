package org.sis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sis.board.model.Criteria;
import org.sis.board.model.ComReplyVO;

public interface ComReplyMapper {
	
	@Insert("insert into tbl_reply_com (bno,content,mmid) values(#{bno},#{content},#{mmid})")
	public int insert(ComReplyVO vo);
	
	@Select("select * from tbl_reply_com where bno=#{bno} order by rno asc")
	public List<ComReplyVO> list(@Param("bno") Integer bno);
	
	@Select("select * from tbl_reply_com where bno=#{bno} order by rno asc limit #{skip} , 10")
	public List<ComReplyVO> listPage(Criteria cri);
	
	@Select("select * from tbl_reply_com where rno=#{rno}")
	public ComReplyVO select(@Param("rno")Integer rno);
	
	@Delete("delete from tbl_reply_com where rno=#{rno}")
	public int delete(@Param("rno") Integer rno);
	
	@Delete("delete from tbl_reply_com where bno=#{bno}")
	public int deleteAll(@Param("bno") Integer bno);
	
	@Update("update tbl_reply_com set reply = #{reply} where rno = #{rno}")
	public int update(ComReplyVO vo);
	
	@Select("select count(*) from tbl_reply_com where bno =#{bno}")
	public int CountReply(@Param("bno") Integer bno);	
	
	

}