package org.sis.board.service;

import java.util.List;

import org.sis.board.model.BoardAttachVO;
import org.sis.board.model.BoardVO;
import org.sis.board.model.Criteria;
import org.sis.mapper.AttachMapper;
import org.sis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService  {
	
	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private AttachMapper attachMapper;

	@Override
	public void register(BoardVO vo) {
		mapper.insert(vo);
		
		if(vo.getAttachList() == null || vo.getAttachList().size() <=0) {
			return;
		}
		
		vo.getAttachList().forEach(attach->{
			
			attach.setBno(vo.getBno());
			attachMapper.insert(attach);
		});
		
	}

	@Override
	public BoardVO get(Integer Key) {
		
		
		return mapper.select(Key);	}

	@Override
	public int modify(BoardVO vo) {	
					
		//return mapper.update(vo);
		
		attachMapper.deleteAll(vo.getBno());
		boolean modifyResult = mapper.update(vo) == 1;
		
		if(modifyResult && vo.getAttachList() != null && vo.getAttachList().size() > 0) {
			vo.getAttachList().forEach(attach ->{
				attach.setBno(vo.getBno());
				attachMapper.insert(attach);
			});
		}
		return modifyResult ? 1:0;
		
		
		
		
	}

	@Override
	@Transactional
	public int remove(Integer key) {
		attachMapper.deleteAll(key);		
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

	@Override
	public List<BoardAttachVO> getAttachList(Integer bno) {
		// TODO Auto-generated method stub
		return attachMapper.findbybno(bno);
	}
}
