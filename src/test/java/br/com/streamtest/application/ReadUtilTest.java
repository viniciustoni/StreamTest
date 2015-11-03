package br.com.streamtest.application;

import org.junit.Assert;
import org.junit.Test;

import br.com.streamtest.core.Stream;
import br.com.streamtest.core.impl.UniqueStreamImpl;
import br.com.streamtest.exception.NoCharException;

/**
 * Junit para a classe de {@link ReadUtil}
 * 
 * @author Vinicius A Gai
 */
public class ReadUtilTest {

	private static final String STREAM_TEST_HAS_UNIQUE = "aAbBABac";
	private static final String STREAM_TEST_HAS_NO_UNIQUE = "aAbBABaccb";
	private static final char FIRST_UNIQUE_CHAR = 'b';
	
	
	/**
	 * Teste para carregar o primeiro char unico.
	 * @throws NoCharException 
	 */
	@Test
	public void testFirstChar() throws NoCharException {
		
		// Variavel do stream
		final Stream stream = new UniqueStreamImpl(STREAM_TEST_HAS_UNIQUE);
		
		// Executa o método
		final char uniqueChar = ReadUtil.firstChar(stream);
		
		// Valida o retorno
		Assert.assertEquals(FIRST_UNIQUE_CHAR, uniqueChar);
		
	}
	
	/**
	 * Teste para verificar que não há nenhum char unico.
	 * @throws NoCharException 
	 */
	@Test(expected = NoCharException.class)
	public void testFirstCharNoneChar() throws NoCharException {
		
		// Variavel do stream
		final Stream stream = new UniqueStreamImpl(STREAM_TEST_HAS_NO_UNIQUE);
		
		// Executa o método
		ReadUtil.firstChar(stream);
		
		
	}
	
}
