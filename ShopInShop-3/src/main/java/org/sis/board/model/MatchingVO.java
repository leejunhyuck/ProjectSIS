package org.sis.board.model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MatchingVO {

	private Integer bno; //_pk
	private String title;
	private String content;
	private Integer budget;
	private String location;
	@DateTimeFormat( pattern = "yyyy/MM/dd HH:mm:ss" )
	private Timestamp regdate;
	private String stype;
	private String mmid; //_fk ( tbl_member( mmid ) )

	
	
	
	private int replycnt;
	
	private List<MatchingAttachVO> attachList;
}
