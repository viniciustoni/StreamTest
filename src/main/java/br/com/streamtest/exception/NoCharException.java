package br.com.streamtest.exception;

/**
 * Classe de exception para caso não haja nenhum char de retorno.
 * 
 * @author Vinicius A Gai
 *
 */
public class NoCharException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3326638610393346002L;

	public NoCharException() {
		super();
	}

	public NoCharException(String message) {
		super(message);
	}

}
