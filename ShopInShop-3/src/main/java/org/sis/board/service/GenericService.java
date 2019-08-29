package org.sis.board.service;

import java.util.List;

import org.sis.board.model.Criteria;

public interface GenericService<VO, Key> {

	public void register(VO vo);
	
	public VO select(Key key);
	
	public int modify(VO vo);
	
	public int remove(Key key);
	
	public List<VO> getList(Criteria cri);
	
	public int selectPageCount(Criteria cri);
	
	
	public int getListCount( Criteria cri ); // R - selectPageCount

	
	
}