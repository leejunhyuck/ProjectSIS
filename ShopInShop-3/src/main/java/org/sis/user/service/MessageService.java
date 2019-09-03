package org.sis.user.service;

import java.util.List;

import org.sis.board.model.Criteria;
import org.sis.user.model.CriteriaMsg;
import org.sis.user.model.MemberVO;
import org.sis.user.model.MessageVO;
import org.springframework.stereotype.Service;
@Service
public interface MessageService extends GenericServiceMsg<MessageVO, Integer>{

	public List<MessageVO> listAll(CriteriaMsg cri);
	
	public boolean updateRead(Integer key);

	public List<MessageVO> getList(MemberVO vo,CriteriaMsg cri);
	
	public int countmsg(MemberVO vo);
	
	public int counturmsg(MemberVO vo);
	
	public List<MessageVO> getsendList(MemberVO vo,CriteriaMsg cri);
	
	public int selectPageCount(MemberVO vo,CriteriaMsg cri); 

	public int selectsendPageCount(MemberVO vo,CriteriaMsg cri); 
	

}
