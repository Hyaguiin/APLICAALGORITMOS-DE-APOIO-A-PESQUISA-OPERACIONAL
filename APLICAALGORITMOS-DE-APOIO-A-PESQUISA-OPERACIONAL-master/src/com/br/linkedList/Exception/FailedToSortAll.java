package com.br.linkedList.Exception;

public class FailedToSortAll extends RuntimeException {
	public FailedToSortAll(String error, Throwable cause) {
		super(error, cause);
	}

	public FailedToSortAll(String error) {
		super(error);
	}

}
