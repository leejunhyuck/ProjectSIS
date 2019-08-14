package org.sis.board.model;

import java.sql.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data

public class BoardVO {

	
	private  Integer bno;
	private String title, content,writer;
	private Date regdate;
	private int replycnt;
	
}