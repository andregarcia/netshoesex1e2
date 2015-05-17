package netshoes.ex1e2.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "CEP Invalido")
public class InvalidZipcodeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6805427375987626977L;

	
	
	public InvalidZipcodeException(String msg) {
		super(msg);
	}
}
