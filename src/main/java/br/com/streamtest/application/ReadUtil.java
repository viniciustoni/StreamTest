package br.com.streamtest.application;

import br.com.streamtest.core.Stream;
import br.com.streamtest.exception.NoCharException;

/**
 * Classe para efetuar a leitura do stream.
 * 
 * @author Vinicius A Gai
 *
 */
public class ReadUtil {

	/**
	 * Retorna o 
	 * @param stream
	 * @return
	 */
	public static char firstChar(final Stream stream) throws NoCharException {
		
		Character uniqueChar = null;
		Character nextChar;
		
		// Percorre o stream
		while (stream.hasNext() && uniqueChar == null) {
			nextChar = stream.getNext();
			
			if (stream.isUnique(nextChar)) {
				uniqueChar = nextChar;
			}
			
		}
		
		// Caso nenhum char encontrado, lança uma exception
		if (uniqueChar == null) {
			throw new NoCharException("Nenhum char unico encontrado para o stream informado.");
		}
		
		return uniqueChar;
	}
	
}
