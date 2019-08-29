package org.sis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sis.board.model.Criteria;
import org.sis.board.model.ShopVO;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShopMapper {
	
	public void insert( ShopVO vo ); // C
	public ShopVO select( Integer bno ); // R
	public int update( ShopVO vo ); // U
	public int delete( Integer bno ); // D
	
	public List<ShopVO> selectAll(); //////
	public List<ShopVO> selectMyAll( String mmid );
	public List<ShopVO> selectPage( Criteria cri );
	public int selectPageCount( Criteria cri );
	public List<ShopVO> search( @Param("map") Map<String, String> map ); //////

	public int selectViewcnt( Integer bno );
	public int updateViewcnt( Integer bno );
	
}