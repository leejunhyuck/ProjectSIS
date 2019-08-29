package org.sis.board.model;

import lombok.Data;

@Data
public class ShopTypeVO {

	private String typewant1;
	private String typewant2;
	private String typewant3;
	private Integer sno; //_fk ( tbl_shop( bno ) )
	private Integer jno; //_fk ( tbl_board_join( bno ) )
	
}
