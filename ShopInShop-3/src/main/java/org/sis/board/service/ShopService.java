package org.sis.board.service;

import java.util.List;

import org.sis.board.model.ListVO;
import org.sis.board.model.ShopImgVO;
import org.sis.board.model.ShopVO;

public interface ShopService extends GenericService<ShopVO, Integer>{

	public List<ShopVO> getMyList( String mmid ); // R - selectMyAll
	
	public int getViewcnt( Integer bno ); // R - selectViewcnt
	
	public int modifyViewcnt( Integer bno ); // R - updateViewcnt
	
	public List<ListVO> getConList(ListVO vo);
	
	public List<ShopVO> recentList();
	
	public List<ShopImgVO> recentListImg();
	
	public List<ShopImgVO> getAttachList(Integer bno);
}
