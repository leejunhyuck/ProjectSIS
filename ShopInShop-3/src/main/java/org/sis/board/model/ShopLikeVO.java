package org.sis.board.model;

import lombok.Data;

@Data
public class ShopLikeVO {

	private Integer lno; //_pk
	private Integer bno; //_fk ( tbl_shop( bno ) )
	private String mmid; //_fk ( tbl_member( mmid ) )
}
