package com.br.linkedList.Exception;

public class NotFound extends RuntimeException {
	public NotFound(String err, Throwable cause) {
		super(err, cause);
	}

	public NotFound(String err) {
		super(err);
	}
}
