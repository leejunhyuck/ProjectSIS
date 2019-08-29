package org.sis.board.service;

import java.util.List;

import org.sis.board.model.Criteria;
import org.sis.board.model.ComReplyVO;
import org.sis.mapper.ComMapper;
import org.sis.mapper.ComReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import lombok.extern.java.Log;


@Service
@Log
@Transactional
public class ComReplyServiceImpl implements ComReplyService {

	@Setter(onMethod_=@Autowired )
	private ComReplyMapper mapper;
	
	@Setter(onMethod_=@Autowired )
	private ComMapper comMapper;
	
	
	@Override
	public void register(ComReplyVO vo) {
		mapper.insert(vo);
		comMapper.updateReplyCnt(vo.getBno(), 1);
	}

	@Override
	public ComReplyVO select(Integer Key) {
		return mapper.select(Key);
	}

	@Override
	public int modify(ComReplyVO vo) {
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {
		ComReplyVO vo = mapper.select(key);
		
		mapper.delete(key);
		return comMapper.updateReplyCnt(vo.getBno(), -1);
	}

	@Override
	public int selectPageCount(Criteria cri) {
		return mapper.CountReply(cri.getBno());
	}
	
	@Override
	public List<ComReplyVO> getSimpleList(Integer bno) {
		return mapper.list(bno);
	}

	@Override
	public List<ComReplyVO> getList(Criteria cri) {
		return mapper.listPage(cri);
	}

	@Override
	public int countReply(int bno) {
		return mapper.CountReply(bno);
	}

	@Override
	public int getListCount(Criteria cri) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}