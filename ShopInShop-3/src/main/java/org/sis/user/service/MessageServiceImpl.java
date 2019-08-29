package org.sis.user.service;

import java.util.List;

import org.sis.mapper.MessageMapper;
import org.sis.user.model.CriteriaMsg;
import org.sis.user.model.MemberVO;
import org.sis.user.model.MessageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private MessageMapper mapper;

 
	@Override
	public void register(MessageVO vo) {
		// TODO Auto-generated method stub
		mapper.insert(vo);
		
	}
	
	@Override
	public MessageVO get(Integer Key) {
		// TODO Auto-generated method stub
		return mapper.select(Key);
	}
	@Override
	public int modify(MessageVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int remove(Integer key) {
		// TODO Auto-generated method stub
		return  mapper.delete(key);
	}
	

	

	@Override
	public List<MessageVO> getList(MemberVO vo, CriteriaMsg cri) {
		// TODO Auto-generated method stub
		return mapper.msgListPage(vo,cri);
	}
	@Override
	public int getListCount(CriteriaMsg cri) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public List<MessageVO> listAll(CriteriaMsg cri) {
		// TODO Auto-generated method stub
		return mapper.msgList();
	}
	@Override
	public boolean updateRead(Integer key) {
		// TODO Auto-generated method stub
		return mapper.updateRead(key);
	}
	@Override
	public List<MessageVO> getList(CriteriaMsg cri) {
		// TODO Auto-generated method stub
		return null;
	}
	
	}