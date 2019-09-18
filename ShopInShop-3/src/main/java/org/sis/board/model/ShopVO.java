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
	private String sname;
	private Integer deposit;
	private Integer rent;
	private String floor;
	private double surface;
	private double p_surface;
	private boolean park;
	private boolean elev;
	private String location;
	private boolean toilet;
	private Integer viewcnt;
	private String mmid; //_fk
	private double lat;
	private double lng;

	
}
