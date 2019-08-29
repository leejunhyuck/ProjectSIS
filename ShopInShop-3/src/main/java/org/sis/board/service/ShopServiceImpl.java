package org.sis.board.service;

import java.util.List;
import java.util.Map;

import org.sis.mapper.ShopMapper;
import org.sis.board.model.Criteria;
import org.sis.board.model.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Service("ShopService")
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {
	
	@Setter( onMethod_ = @Autowired )
	private ShopMapper mapper;

	@Override
	public void register( ShopVO vo ) {
		
		mapper.insert( vo );
	}

	@Override
	public ShopVO select( Integer key ) {
		
		return mapper.select( key );
	}

	@Override
	public int modify( ShopVO vo ) {
		
		int count = mapper.update( vo );
		
		return count;
	}

	@Override
	public int remove( Integer key ) {

		return mapper.delete( key );
	}

	@Override
	public List<ShopVO> getList( Criteria cri ) {
		
		return mapper.selectPage( cri );
	}

	@Override
	public int getListCount( Criteria cri ) {

		return mapper.selectPageCount( cri );
	}

	@Override
	public List<ShopVO> getMyList( String key ) {
		
		return mapper.selectMyAll( key );
	}

	@Override
	public int getViewcnt( Integer bno ) {
		
		return mapper.selectViewcnt( bno );
	}

	@Override
	public int modifyViewcnt( Integer bno ) {
		
		return mapper.updateViewcnt( bno );
	}


	@Override
	public int selectPageCount(Criteria cri) {
		// TODO Auto-generated method stub
		return 0;
	}

}
