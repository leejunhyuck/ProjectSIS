package org.sis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.sis.board.model.ComLikeVO;

public interface ComLikeMapper {
	
	@Insert("insert into tbl_board_com_like(bno,mmid,comlike) values(#{bno},#{mmid},true)")
	public void insert(ComLikeVO vo);
	
	@Select("select * from tbl_board_com_like where bno=#{bno} and mmid=#{mmid}")
	public ComLikeVO check(ComLikeVO vo);

}
