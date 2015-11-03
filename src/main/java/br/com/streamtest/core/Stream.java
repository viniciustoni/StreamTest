package br.com.streamtest.core;

/**
 * Interface contendo os métodos para execuçao das rotinas para o stream.
 * 
 * @author Vinicius A Gai
 */
public interface Stream {

	/**
	 * Carrega o proximo caracter a ser analisado na stream.
	 * 
	 * @return Proximo caracter a ser analisado.
	 */
	char getNext();

	/**
	 * Retorna para verificar se há mais valores validos a serem analisados, ou
	 * seja, se há algum caracter que ainda não foi validade se é unico na
	 * stream.
	 * 
	 * @return true Caso ainda exista caracteres.
	 */
	boolean hasNext();

	/**
	 * Valida se o caracter informado é unico na stream.
	 * 
	 * @return true caso o caracter é unico na stream.
	 */
	boolean isUnique(final char character);

}
