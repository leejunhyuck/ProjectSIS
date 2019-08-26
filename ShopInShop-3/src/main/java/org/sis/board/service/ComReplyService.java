package org.sis.board.service;

import java.util.List;

import org.sis.board.model.Criteria;
import org.sis.board.model.ComReplyVO;

public interface ComReplyService extends GenericService<ComReplyVO, Integer>{

	public List<ComReplyVO> getSimpleList(Integer bno);
	
	public List<ComReplyVO> getList(Criteria cri);
	
	public int countReply(int bno);
	

	
	
	
}
