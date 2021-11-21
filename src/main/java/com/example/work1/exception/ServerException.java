package com.example.work1.exception;

import lombok.Getter;

/**
 * 서버 에러
 * @author derek derek.kim@goodoc.co.kr
 * @since 2020-04-22 18:17:33
 */
@Getter
@SuppressWarnings("serial")
public class ServerException extends RuntimeException {
	private int code;
	private Object[] arguments;
	
	public ServerException(int code, Object... arguments) {
		this.code = code;
		this.arguments = arguments;
	}
}
