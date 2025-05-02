package com.mailsending.exception;

public class InvalidEmailIdException extends RuntimeException {
	public InvalidEmailIdException(String msg)
	{
		super(msg);
	}

}
