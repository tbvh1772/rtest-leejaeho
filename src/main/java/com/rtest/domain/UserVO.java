package com.rtest.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UserVO {
	
	private String user_id;
	
	private String user_passwd;
	
	private String user_name;
	
	private Date user_date;

}
