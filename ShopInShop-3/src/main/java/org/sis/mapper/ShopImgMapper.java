package org.sis.mapper;

import java.util.List;

import org.sis.board.model.ShopImgVO;

public interface ShopImgMapper {
	
	//@Insert("Insert into tbl_shop_img(bno,fileName,uploadPath,uuid) values(#{bno},#{fileName},#{uploadPath},#{uuid})")
	public void insert(ShopImgVO dto);
	
	//@Select("select * from tbl_shop_img where bno = #{bno}")
	public List<ShopImgVO> findbybno(int bno);
	
	//@Delete("")
	public void delete(String uuid);
	
	//@Delete("delete from tbl_shop_img where bno = #{bno}")
	public void deleteAll(int bno);
	
	//@Select("select * from tbl_shop_img where uploadpath =  to_char(now()-1 , 'yyyy'")
	public List<ShopImgVO> getOldFiles();

}
