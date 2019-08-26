package org.sis.board.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class ComVO {

	
	private Integer bno;
	private String title, content,mmid;
	private String category;
	private Date regdate;
	private int replycnt;
	private int comlike;
	private int viewcnt;
	
	private List<ComAttachVO> attachList;
	
}