package com.fastcampus.biz.user;

import java.util.Date;

import lombok.Data;

// VO Å¬·¡½º
@Data
public class UserVO {
	private String id;
	private String password;
	private String name;
	private Date regDate;
	private String role;

}
