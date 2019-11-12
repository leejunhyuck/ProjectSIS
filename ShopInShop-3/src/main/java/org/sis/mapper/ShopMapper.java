package org.sis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.sis.board.model.ComVO;
import org.sis.board.model.Criteria;
import org.sis.board.model.ListVO;
import org.sis.board.model.ShopImgVO;
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
	
	public List<ListVO> selectList(ListVO vo);
	
	public List<ListVO> selectconList(ListVO vo);
	
	@Select("select * from tbl_shop order by bno desc limit 0,5")
	public List<ShopVO> recentList();
	
	@Select("select shop.bno, img.fileName, img.uuid, img.uploadPath from tbl_shop  as shop join tbl_shop_img as img on shop.bno = img.bno group by bno order by bno desc limit 0,5")
	public List<ShopImgVO> recentListImg();
	
	@Select("select shop.bno, img.fileName, img.uuid, img.uploadPath from tbl_shop  as shop join tbl_shop_img as img on shop.bno = img.bno group by bno order by bno desc limit #{skip}, #{amount}")
	public List<ShopImgVO> selectPageImg( Criteria cri);

	
}