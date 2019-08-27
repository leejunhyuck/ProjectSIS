package org.sis.mapper;

import java.util.List;

import org.sis.board.model.MatchingAttachVO;

public interface MatchingAttachMapper {
	
	//@Insert("Insert into tbl_attach(bno,fileName,uploadPath,uuid) values(#{bno},#{fileName},#{uploadPath},#{uuid})")
	public void insert(MatchingAttachVO dto);
	
	//@Select("select * from tbl_attach where bno = #{bno}")
	public List<MatchingAttachVO> findbybno(int bno);
	
	//@Delete("")
	public void delete(String uuid);
	
	//@Delete("delete from tbl_attach where bno = #{bno}")
	public void deleteAll(int bno);
	
	//@Select("select * from tbl_attach where uploadpath =  to_char(now()-1 , 'yyyy'")
	public List<MatchingAttachVO> getOldFiles();

}
