package org.sis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sis.user.model.CriteriaMsg;
import org.sis.user.model.MemberVO;
import org.sis.user.model.MessageVO;


public interface MessageMapper {

	@Insert("insert into tbl_msg (mmid,whom,title,content) values(#{mmid},#{whom},#{title},#{content})")
	public void insert(MessageVO vo);
	
	@Select("select * from tbl_msg where msgnum=#{msgnum}")
	public MessageVO select(Integer msgnum);

	@Delete("delete from tbl_msg where msgnum=#{msgnum}")
	public int delete(Integer msgnum);
	
	@Select("select * from tbl_msg  order by msgnum desc")
	public List<MessageVO> msgList();

	@Select("select * from tbl_msg where mmid = #{vo.mmid} order by msgnum desc limit #{cri.skip} , #{cri.amount}")
	public List<MessageVO> msgListPage(@Param("vo")MemberVO vo, @Param("cri")CriteriaMsg cri);
	
	@Update("update tbl_msg set readed=1 where msgnum =#{msgnum}")
	public boolean updateRead(@Param("msgnum") Integer msgnum);
}
