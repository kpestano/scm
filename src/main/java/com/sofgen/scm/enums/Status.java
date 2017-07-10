package com.sofgen.scm.enums;

public enum Status {

	ACTIVE(1), INACTIVE(0);

	private final int code;

	Status(int code){
		this.code = code;
	}
	
	public int getIntValue() {
		return code;
	}

}
