package org.sis.board.test.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class MatchingVO {

	
	private Integer bno;
	private String title, content,mid;
	private Date regdate;
	private int replycnt;
	
	private List<BoardAttachVO> attachList;
	
}