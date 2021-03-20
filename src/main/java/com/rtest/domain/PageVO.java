package com.rtest.domain;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class PageVO {

	private Criteria cri; //pageNum , amount
	private int total; // 총 게시글 갯수
	private boolean prev , next; // 이전 , 다음
	private int startPage;
	private int endPage;
	
	public PageVO (Criteria cri , int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;  
		this.startPage = endPage - 9;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));  
		if( realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;
		this.next = realEnd > this.endPage;
		
		
	}


}
