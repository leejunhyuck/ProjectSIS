package org.sis.board.model;

import lombok.Data;

@Data
public class ShopImgVO {
	
	private String uuid;
	private Integer bno; //_fk ( tbl_shop( bno ) )
	private String fileName;
	private String uploadPath;

}
