package org.sis.board.service;

import java.util.List;


import org.sis.board.model.Criteria;
import org.sis.board.model.MatchingAttachVO;
import org.sis.board.model.MatchingVO;
import org.sis.mapper.AttachMapper;
import org.sis.mapper.MatchingAttachMapper;
import org.sis.mapper.MatchingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatchingServiceImpl implements MatchingService{
	
	@Autowired
	private MatchingMapper mapper;
	
	@Autowired
	private MatchingAttachMapper attachMapper;
	

	@Override
	public void register(MatchingVO vo) {
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
	public MatchingVO select(Integer Key) {
		mapper.updateViewCnt(Key);
		return mapper.select(Key);
	}
	
	@Override
	public int modify(MatchingVO vo) {
		
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
	public List<MatchingVO> getList(Criteria cri) {
		return mapper.selectPage(cri);
	}

	@Override
	public int selectPageCount(Criteria cri) {
		return mapper.selectPageCount(cri);
	}
	
	@Override
	public List<MatchingAttachVO> getAttachList(Integer bno) {
		return attachMapper.findbybno(bno);
	}


	@Override
	public int getListCount(Criteria cri) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List<Integer> getPrevNext(Integer bno) {
		
		return mapper.NextPrevBno(bno);
	}


}
