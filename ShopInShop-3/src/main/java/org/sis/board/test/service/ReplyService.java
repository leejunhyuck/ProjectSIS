package org.sis.board.test.service;

import java.util.List;

import org.sis.board.test.model.Criteria;
import org.sis.board.test.model.ReplyVO;

public interface ReplyService extends GenericService<ReplyVO, Integer>{

	public List<ReplyVO> getSimpleList(Integer bno);
	
	public List<ReplyVO> getList(Criteria cri);
	
	public int countReply(int bno);
	
	public void addTest(String str);
	
	
	
}
