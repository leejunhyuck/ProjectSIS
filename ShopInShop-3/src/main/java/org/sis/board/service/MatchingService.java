package org.sis.board.service;

import java.util.List;


import org.sis.board.model.MatchingAttachVO;
import org.sis.board.model.MatchingVO;


public interface MatchingService extends GenericService<MatchingVO, Integer>{

	public List<MatchingAttachVO> getAttachList(Integer bno);
	
	public List<Integer> getPrevNext(Integer bno);
	
	
}
