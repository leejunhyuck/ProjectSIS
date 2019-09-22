package org.sis.board.service;

import java.util.List;

import org.sis.board.model.ComAttachVO;
import org.sis.board.model.ComVO;
import org.sis.board.model.Criteria;

public interface ComService extends GenericService<ComVO, Integer>{

	public List<ComAttachVO> getAttachList(Integer bno);
	
	public List<Integer> getPrevNext(Integer bno);
	
	public List<ComVO> hotList();
	
	
	
}
