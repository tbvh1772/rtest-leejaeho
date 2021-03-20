package com.rtest.domain;


import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CommunityVO {

	private int post_no;
	
	private String user_id;
	
	private String post_title;
	
	private String post_content;
	
	private Date post_date;
	
	private Date post_updatedate;
	
	private String fileName;
	
	private MultipartFile uploadFile;
}
