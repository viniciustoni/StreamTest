package br.com.streamtest.core.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.streamtest.core.Stream;
import br.com.streamtest.core.impl.UniqueStreamImpl;

/**
 * Classe de teste para a classe de {@link UniqueStreamImpl}
 * 
 * @author Vinicius A Gai
 *
 */
public class UniqueStreamTest {

	private final static String STREAM_TEST = "aAaBbBC";
	
	private Stream stream;
	
	/**
	 * Teste com sucesso
	 */
	@Test
	public void testGetNext() {
		stream = new UniqueStreamImpl(STREAM_TEST);
		
		Assert.assertTrue(stream.hasNext());
		Assert.assertEquals('a', stream.getNext());
		
		Assert.assertTrue(stream.hasNext());
		Assert.assertEquals('A', stream.getNext());
		
		Assert.assertTrue(stream.hasNext());
		Assert.assertEquals('B', stream.getNext());
		
		Assert.assertTrue(stream.hasNext());
		Assert.assertEquals('b', stream.getNext());
		
		Assert.assertTrue(stream.hasNext());
		Assert.assertEquals('C', stream.getNext());
		
		Assert.assertFalse(stream.hasNext());
	}
	
	/**
	 * Teste com sucesso
	 */
	@Test
	public void testIsUnique() {
		stream = new UniqueStreamImpl(STREAM_TEST);
		
		final boolean isUnique = stream.isUnique('C');
		
		Assert.assertTrue(isUnique);
	}
	
	/**
	 * Teste com sucesso
	 */
	@Test
	public void testIsNotUnique() {
		stream = new UniqueStreamImpl(STREAM_TEST);
		
		final boolean isUnique = stream.isUnique('a');
		
		Assert.assertFalse(isUnique);
	}
	
	/**
	 * Teste com o stream vazio
	 */
	@Test
	public void testGetNextVazio() {
		stream = new UniqueStreamImpl("");
		Assert.assertFalse(stream.hasNext());
	}
	
}
