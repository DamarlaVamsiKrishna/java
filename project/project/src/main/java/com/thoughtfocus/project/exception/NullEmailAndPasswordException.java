package com.thoughtfocus.project.exception;

public class NullEmailAndPasswordException extends RuntimeException {
	public NullEmailAndPasswordException(String msg) {
		super(msg);
	}
}
