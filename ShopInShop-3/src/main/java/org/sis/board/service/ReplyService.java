package org.sis.board.service;

import java.util.List;

import org.sis.board.model.Criteria;
import org.sis.board.model.ReplyVO;

public interface ReplyService extends GenericService<ReplyVO, Integer>{

	public List<ReplyVO> getSimpleList(Integer bno);
	
	public List<ReplyVO> getList(Criteria cri);
	
	public int countReply(int bno);
	
	public void addTest(String str);
	
	
	
}
