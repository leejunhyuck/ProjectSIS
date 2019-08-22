package org.sis.board.test.model;

import lombok.Data;

@Data
public class ComAttachVO {
	
	private Integer bno;
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
}
