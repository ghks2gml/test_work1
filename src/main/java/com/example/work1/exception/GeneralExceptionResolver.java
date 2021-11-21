package com.example.work1.exception;

import com.example.work1.model.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * 공통에러 처리
 * @author mail.kjh@gmail.com
 * @since 2021-11-22
 */
@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GeneralExceptionResolver extends ResponseEntityExceptionHandler {
	private final MessageSource msg;

	@ExceptionHandler(ServerException.class)
	public ResponseEntity<ErrorMessage> handleServerException(ServerException ex, WebRequest request){
		log.error("call ServerException", ex);
		ErrorMessage error = new ErrorMessage(ex.getCode(), ex.getMessage());
		return new ResponseEntity<ErrorMessage>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> resolveException(Exception ex, WebRequest request) {
		log.error("call Exception", ex);
		ErrorMessage error = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
