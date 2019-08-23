package org.sis.board.test.service;

import java.util.List;

import org.sis.board.test.model.Criteria;
import org.sis.board.test.model.ComReplyVO;

public interface ComReplyService extends GenericService<ComReplyVO, Integer>{

	public List<ComReplyVO> getSimpleList(Integer bno);
	
	public List<ComReplyVO> getList(Criteria cri);
	
	public int countReply(int bno);
	

	
	
	
}
