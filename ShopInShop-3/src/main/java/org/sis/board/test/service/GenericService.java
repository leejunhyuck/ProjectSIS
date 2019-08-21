package org.sis.board.test.service;

import java.util.List;

import org.sis.board.test.model.Criteria;

public interface GenericService<VO, K> {

	public void register(VO vo);
	
	public VO get(K Key);
	
	public int modify(VO vo);
	
	public int remove(K key);
	
	public List<VO> getList(Criteria cri);
	
	public int getListCount(Criteria cri);
	
}