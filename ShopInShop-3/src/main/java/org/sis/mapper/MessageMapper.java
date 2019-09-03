package org.sis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.sis.board.model.Criteria;
import org.sis.user.model.CriteriaMsg;
import org.sis.user.model.MemberVO;
import org.sis.user.model.MessageVO;


public interface MessageMapper {

	@Insert("insert into tbl_msg (mmid,whom,title,content) values(#{mmid},#{whom},#{title},#{content})")
	public void insert(MessageVO vo);
	//message 등록할떄
	
	@Select("select * from tbl_msg where msgnum=#{msgnum}")
	public MessageVO select(Integer msgnum);
	//message한개불러서 볼떄

	@Delete("delete from tbl_msg where msgnum=#{msgnum}")
	public int delete(Integer msgnum);
	//message지울떄 
	
	@Select("select * from tbl_msg  order by msgnum desc")
	public List<MessageVO> msgList();
	//message 모두 불러올떄(안씀)

	@Update("update tbl_msg set readed=1 where msgnum =#{msgnum}")
	public boolean updateRead(@Param("msgnum") Integer msgnum);
	//message 읽음 안읽음 판별
	
	@Select("select count(*) from tbl_msg where whom =#{mmid}")
	public int Countmsg(MemberVO vo);	
	//message 온거 총숫자세는쿼리
	
	@Select("select count(*) from tbl_msg where whom =#{mmid} and readed=0")
	public int Countreadmsg(MemberVO vo);	
	//message 온것중 안읽은 숫자세는쿼리
	
	@Select("select * from tbl_msg where whom = #{vo.mmid} order by msgnum desc limit #{cri.skip} , #{cri.amount}")
	public List<MessageVO> msgListPage(@Param("vo")MemberVO vo, @Param("cri")CriteriaMsg cri);
	//message 내가받은 것들 불러오는거
	
	@Select("select * from tbl_msg where mmid = #{vo.mmid} order by msgnum desc limit #{cri.skip} , #{cri.amount}")
	public List<MessageVO> msgsendListPage(@Param("vo")MemberVO vo, @Param("cri")CriteriaMsg cri);
	//message 내가 보낸것들 불러올떄 (불러오는 갯수 설정되있음)
	
	@Select(" select count(msgnum) from tbl_msg where whom = #{vo.mmid}")
	public int selectPageCount(@Param("vo")MemberVO vo, @Param("cri")CriteriaMsg cri); 
	
	@Select(" select count(msgnum) from tbl_msg where mmid = #{vo.mmid}")
	public int selectsendPageCount(@Param("vo")MemberVO vo, @Param("cri")CriteriaMsg cri);
	
}
