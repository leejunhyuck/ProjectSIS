package org.sis.board.test.service;

import java.util.List;

import org.sis.board.test.model.BoardAttachVO;
import org.sis.board.test.model.ComAttachVO;
import org.sis.board.test.model.Criteria;
import org.sis.board.test.model.ComVO;
import org.sis.mapper.AttachMapper;
import org.sis.mapper.ComAttachMapper;
import org.sis.mapper.ComMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComServiceImpl implements ComService{
	
	@Autowired
	private ComMapper mapper;
	
	@Autowired
	private ComAttachMapper attachMapper;
	

	@Override
	public void register(ComVO vo) {
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
	public ComVO get(Integer Key) {
		return mapper.select(Key);
	}
	
	@Override
	public int modify(ComVO vo) {
		
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
	public List<ComVO> getList(Criteria cri) {
		return mapper.selectPage(cri);
	}

	@Override
	public int getListCount(Criteria cri) {
		return mapper.selectPageCount(cri);
	}
	
	@Override
	public List<ComAttachVO> getAttachList(Integer bno) {
		return attachMapper.findbybno(bno);
	}

}
