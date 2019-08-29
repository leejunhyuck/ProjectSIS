package org.sis.board.model;

import java.sql.Timestamp;
//import javax.persistence.Entity;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
//@Entity
public class ShopVO {

	private Integer bno; //_pk
	private String content;
	@DateTimeFormat( pattern = "yyyy/MM/dd HH:mm:ss" )
	private Timestamp regdate;
	@DateTimeFormat( pattern = "yyyy/MM/dd HH:mm:ss" )
	private Timestamp updatedate;
	private String stype;
	private Integer deposit;
	private Integer rent;
	private Integer floor;
	private Integer surface;
	private Integer p_surface;
	private Integer park;
	private Integer elev;
	private String location;
	private Integer toilet;
	private Integer viewcnt;
	private String mmid; //_fk
	
}
