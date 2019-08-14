package org.sis.board.service;

import java.util.List;

import org.sis.board.model.BoardVO;
import org.sis.board.model.Criteria;
import org.sis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService  {
	
	@Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardVO vo) {
		mapper.insert(vo);
	}

	@Override
	public BoardVO get(Integer Key) {
		
		
		return mapper.select(Key);	}

	@Override
	public int modify(BoardVO vo) {
	
		return mapper.update(vo);
	}

	@Override
	public int remove(Integer key) {
		
		return mapper.delete(key);
	}

	

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.selectPage(cri);
	}

	@Override
	public int getListCount(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.selectPageCount(cri);
	}

	@Override
	public List<BoardVO> listAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
