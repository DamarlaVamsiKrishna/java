package com.thoughtfocus.project.exception;

public class UnknownUserException extends RuntimeException {
	public UnknownUserException(String msg) {
		super(msg);
	}
}
