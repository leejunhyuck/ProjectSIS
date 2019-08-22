package org.sis.board.test.service;

import java.util.List;

import org.sis.board.test.model.ComAttachVO;
import org.sis.board.test.model.ComVO;

public interface ComService extends GenericService<ComVO, Integer>{

	public List<ComAttachVO> getAttachList(Integer bno);
	
	
	
}
