package uy.edu.ude.exception;

import java.io.Serializable;

public class DaoException extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

	public DaoException(String mensaje) {
		super(mensaje);
	}

	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoException(Throwable cause) {
		super(cause);
	}
}
