package com.br.linkedList.Exception;

public class FailedToDelete extends RuntimeException{
	public FailedToDelete(String err, Throwable cause) {
		super(err, cause);
	}
	public FailedToDelete(String err) {
		super(err);

	}
}
