package org.sis.board.test.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data

public class BoardVO {

	
	private  Integer bno;
	private String title, content,writer;
	private Date regdate;
	private int replycnt;
	
	private List<BoardAttachVO> attachList;
	
}