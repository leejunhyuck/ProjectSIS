package org.sis.user.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageMakerMsg {
	
	private CriteriaMsg cri;
	private boolean prev, next;
	private int totalCount;
	private int current, start, end;
	private List<Integer> pageList;
	
	public PageMakerMsg(CriteriaMsg cri, int totalCount) {
		
		this.current = cri.getPage();
		this.totalCount = totalCount;
		this.cri = cri;
		
		int tempEnd = ((int)Math.ceil(current/10.0)) *10;
		
		start = tempEnd - 9;
		
		prev = start != 1;
		
		int tempTotal = tempEnd * cri.getAmount();
		
		if(tempTotal > totalCount) {
			end = (int)(Math.ceil(totalCount / (double)cri.getAmount()));
		}else {
			end = tempEnd;
		}
		
		next = tempTotal < totalCount;		
		
		List<Integer> pages = new ArrayList<>();
		for(int i = start; i<=end ; i++) {
			pages.add(i);
		}
		pageList = pages;
	}
	
	public String getLink(String path, int pageNum) {
		UriComponentsBuilder builder = 
				UriComponentsBuilder.fromPath(path)
				.queryParam("page", pageNum).queryParam("amount",cri.getAmount());
		
		return builder.toUriString();
	}

}