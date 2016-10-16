package uy.edu.ude.exception;

import java.io.Serializable;

public class ServiceException extends RuntimeException implements Serializable{

	private static final long serialVersionUID = 1L;

	public ServiceException(String mensaje) {
		super(mensaje);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}
