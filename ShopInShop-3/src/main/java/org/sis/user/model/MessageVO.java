package org.sis.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class MessageVO {
	
	private String mmid;   
	private Integer msgnum; // 메시지 pk
    private String whom;    // 수신자
    private String sender;        // 발신자
    private String content;        // 메시지 내용
    private String title;    //제목
    private Date regdate;  //작성일
    private boolean gubun;  //확인
    
}

