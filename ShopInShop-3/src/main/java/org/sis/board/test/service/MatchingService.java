package org.sis.board.test.service;

import java.util.List;

import org.sis.board.test.model.BoardAttachVO;
import org.sis.board.test.model.MatchingVO;


public interface MatchingService extends GenericService<MatchingVO, Integer>{

	public List<BoardAttachVO> getAttachList(Integer bno);
	
	
	
}
