package com.mailsending.handler;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mailsending.dto.EmployeeResponse;
import com.mailsending.exception.InvalidAgeException;
import com.mailsending.exception.InvalidEmailIdException;
import com.mailsending.exception.InvalidPasswordException;
import com.mailsending.exception.InvalidUsernameException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidEmailIdException.class)
	public ResponseEntity<EmployeeResponse> handleInvalidEmailIdException(InvalidEmailIdException ie)
	{
		String msg=ie.getMessage();
		EmployeeResponse resp=new EmployeeResponse();
		resp.setMsg(msg);
		resp.setTimestamp(new Date());
		return new ResponseEntity<EmployeeResponse>(resp,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidAgeException.class)
	public ResponseEntity<EmployeeResponse> handleInvalidAgeException(InvalidAgeException iage)
	{
		String msg=iage.getMessage();
		EmployeeResponse resp=new EmployeeResponse();
		resp.setMsg(msg);
		resp.setTimestamp(new Date());
		return new ResponseEntity<EmployeeResponse>(resp,HttpStatus.NOT_FOUND);
	
	}
	@ExceptionHandler(InvalidUsernameException.class)
	public ResponseEntity<EmployeeResponse> handleInvalidUsernameException(InvalidUsernameException iuser)
	{
		String msg=iuser.getMessage();
		EmployeeResponse resp=new EmployeeResponse();
		resp.setMsg(msg);
		resp.setTimestamp(new Date());
		return new ResponseEntity<EmployeeResponse>(resp,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(InvalidPasswordException.class)
	public ResponseEntity<EmployeeResponse> handleInvalidPasswordException(InvalidPasswordException ipass)
	{
		String msg=ipass.getMessage();
		EmployeeResponse resp=new EmployeeResponse();
		resp.setMsg(msg);
		resp.setTimestamp(new Date());
		return new ResponseEntity<EmployeeResponse>(resp,HttpStatus.NOT_FOUND);
	
	}

}
