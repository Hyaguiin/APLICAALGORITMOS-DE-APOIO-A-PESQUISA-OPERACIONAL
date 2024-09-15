package com.br.linkedList.Exception;

public class FailedToCreate extends RuntimeException {
	public FailedToCreate(String error, Throwable cause) {
		super(error, cause);
	}

	public FailedToCreate(String error) {
		super(error);
	}

}
