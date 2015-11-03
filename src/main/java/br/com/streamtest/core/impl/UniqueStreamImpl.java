package br.com.streamtest.core.impl;

import org.apache.commons.lang3.StringUtils;

import br.com.streamtest.core.Stream;

/**
 * Implementação para a classe de Stream, onde através de uma stream, retorna somente todos os caracteres uma unica vez, ou seja, aAabB a classe ir.
 * 
 * @author Vinicius A Gai
 */
public class UniqueStreamImpl implements Stream {

	private String stream;
	private String streamAux;
	
	/**
	 * Constructor.
	 * 
	 * @param stream
	 *            Stream para processamento.
	 */
	public UniqueStreamImpl(String stream) {
		super();
		this.stream = stream;
		this.streamAux = stream;
	}

	@Override
	public char getNext() {
		
		// carrega o  primeiro char
		final char nextChar = streamAux.charAt(0);
		
		// Remove o char para nao precisar mais passar por ele, pois assim,melhora a performance.
		this.streamAux = StringUtils.remove(streamAux, nextChar);
		
		return nextChar;
	}

	@Override
	public boolean hasNext() {
		return StringUtils.isNotBlank(streamAux);
	}

	@Override
	public boolean isUnique(char character) {
		return StringUtils.countMatches(stream, String.valueOf(character)) == 1;
	}

}
