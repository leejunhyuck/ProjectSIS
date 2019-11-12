package org.sis.board.service;

import java.util.List;
import java.util.Map;

import org.sis.mapper.ShopImgMapper;
import org.sis.mapper.ShopMapper;
import org.sis.board.model.Criteria;
import org.sis.board.model.ListVO;
import org.sis.board.model.ShopImgVO;
import org.sis.board.model.ShopVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Service("ShopService")
public class ShopServiceImpl implements ShopService {
	
	@Setter( onMethod_ = @Autowired )
	private ShopMapper mapper;
	
	@Setter( onMethod_ = @Autowired )
	private ShopImgMapper imgMapper;

	@Override
	public void register( ShopVO vo ) {
		mapper.insert(vo);
		
		if(vo.getAttachList() == null || vo.getAttachList().size() <=0) {
			return;
		}
		
		vo.getAttachList().forEach(attach->{
			
			attach.setBno(vo.getBno());
			imgMapper.insert(attach);
		});
	}

	@Override
	public ShopVO select( Integer key ) {
		
		return mapper.select( key );
	}

	@Override
	public int modify( ShopVO vo ) {
		imgMapper.deleteAll(vo.getBno());
		boolean modifyResult = mapper.update(vo) == 1;
		
		if(modifyResult && vo.getAttachList() != null && vo.getAttachList().size() > 0) {
			vo.getAttachList().forEach(attach ->{
					attach.setBno(vo.getBno());
					imgMapper.insert(attach);
			});
		}
		return modifyResult ? 1:0;
	}

	@Override
	@Transactional
	public int remove( Integer key ) {
		imgMapper.deleteAll(key);
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

	@Override
	public List<ListVO> getConList(ListVO vo) {
		
		
		
		return mapper.selectconList(vo);
	}

	@Override
	public List<ShopVO> recentList() {
		return mapper.recentList();
	}

	@Override
	public List<ShopImgVO> getAttachList(Integer bno) {
		return imgMapper.findbybno(bno);
	}

	@Override
	public List<ShopImgVO> recentListImg() {
		return mapper.recentListImg();
	}

	@Override
	public List<ShopImgVO> getPageImg(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.selectPageImg(cri);
	}

}
