package org.sis.board.service;

import java.util.List;
import java.util.Map;

import org.sis.board.model.Criteria;
import org.sis.board.model.ShopVO;

public interface ShopService extends GenericService<ShopVO, Integer>{

	public List<ShopVO> getMyList( String mmid ); // R - selectMyAll
	
	public int getViewcnt( Integer bno ); // R - selectViewcnt
	
	public int modifyViewcnt( Integer bno ); // R - updateViewcnt
	
}
