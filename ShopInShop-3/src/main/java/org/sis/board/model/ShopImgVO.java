package org.sis.board.model;

import lombok.Data;

@Data
public class ShopImgVO {
	
	private String imgname;
	private String uuid;
	private Integer bno; //_fk ( tbl_shop( bno ) )

}
