package org.sis.board.model;

import lombok.Data;

@Data
public class ListVO {

	private String stype,depositmin,rentmin,rentmax,surfacemin,surfacemax,depositmax,floor;
	boolean park,elev,toilet;
	private double nelat;
	private double nelng;
	private double swlat;
	private double swlng;
}
