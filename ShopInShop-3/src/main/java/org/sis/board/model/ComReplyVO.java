package org.sis.board.model;

import java.util.Date;

import lombok.Data;

@Data
public class ComReplyVO {
	
	private Integer rno;
	private Integer bno;
	private String content;
	private String mid;
	private Date replyDate;
	
	
	
}