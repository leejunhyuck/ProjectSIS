package org.sis.board.test.service;

import java.util.List;

import org.sis.board.test.model.BoardAttachVO;
import org.sis.board.test.model.BoardVO;

public interface BoardService extends GenericService<BoardVO, Integer>{

	public List<BoardVO> listAll();
	
	public List<BoardAttachVO> getAttachList(Integer bno);
	
	
	
}
