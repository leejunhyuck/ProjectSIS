package org.sis.board.service;

import java.util.List;

import org.sis.board.model.BoardAttachVO;
import org.sis.board.model.BoardVO;

public interface BoardService extends GenericService<BoardVO, Integer>{

	public List<BoardVO> listAll();
	
	public List<BoardAttachVO> getAttachList(Integer bno);
	
	
	
}
