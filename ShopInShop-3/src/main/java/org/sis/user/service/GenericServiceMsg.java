package org.sis.user.service;

import java.util.List;

import org.sis.user.model.CriteriaMsg;


public interface GenericServiceMsg<VO, K> {

	public void register(VO vo);
	
	public VO get(K Key);
	
	public int modify(VO vo);
	
	public int remove(K key);
	
	public List<VO> getList(CriteriaMsg cri);
	
	public int getListCount(CriteriaMsg cri);

	
	
}