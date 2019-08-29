package org.sis.board.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MatchingVO {

	
	private Integer bno;
	private String title, content,mmid;
	private Date regdate;
	private int replycnt;
	private int viewcnt;
	
	private List<MatchingAttachVO> attachList;
	
}