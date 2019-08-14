package org.sis.board.service;

import java.util.List;

import org.sis.board.model.Criteria;
import org.sis.board.model.ReplyVO;
import org.sis.mapper.BoardMapper;
import org.sis.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import lombok.extern.java.Log;


@Service
@Log
@Transactional
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_=@Autowired )
	private ReplyMapper mapper;
	
	@Setter(onMethod_=@Autowired )
	private BoardMapper boardmapper;
	
	
	
	
	@Override
	public void register(ReplyVO vo) {
		mapper.insert(vo);
		boardmapper.updateReplyCnt(vo.getBno(), 1);
	}

	@Override
	public ReplyVO get(Integer Key) {
		// TODO Auto-generated method stub
		return mapper.select(Key);
	}

	@Override
	public int modify(ReplyVO vo) {
		// TODO Auto-generated method stub
		return mapper.update(vo);
	}


	
	@Override
	public int remove(Integer key) {
		
		ReplyVO vo = mapper.select(key);
		
		
		mapper.delete(key);
		return boardmapper.updateReplyCnt(vo.getBno(), -1);
	}

	@Override
	public int getListCount(Criteria cri) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Transactional
	@Override
	public void addTest(String str) {
		
		mapper.insert1(str);
		mapper.insert2(str);
		
	}
	
	@Override
	public List<ReplyVO> getSimpleList(Integer bno) {
		// TODO Auto-generated method stub
		return mapper.list(bno);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.listPage(cri);
	}

	@Override
	public int countReply(int bno) {
		// TODO Auto-generated method stub
		return mapper.CountReply(bno);
	}
	
	
	
}