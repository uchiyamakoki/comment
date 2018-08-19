package com.momoka.dianping.constant;

public enum PageCodeEnum {
	ADD_SUCCESS(1000,"新增成功!"),
	ADD_FAIL(1001,"新增失败!"),;
	
	
	private Integer code;
	private String msg;
	
	public static final String KEY="pageCode";
	
	private PageCodeEnum(Integer code,String msg) {
		// TODO Auto-generated constructor stub
		this.code=code;
		this.msg=msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
