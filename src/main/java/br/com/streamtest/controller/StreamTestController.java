package br.com.streamtest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.streamtest.application.ReadUtil;
import br.com.streamtest.core.Stream;
import br.com.streamtest.core.impl.UniqueStreamImpl;
import br.com.streamtest.exception.NoCharException;

/**
 * Controller para o teste de stream.
 * 
 * @author Vinicius A Gai
 *
 */
@RestController
public class StreamTestController {

	private final Logger logger = LoggerFactory.getLogger(StreamTestController.class);

	/**
	 * Consulta uma malha de roteiro.
	 * 
	 * @param malha
	 * @return Dados da consulta da malha
	 * @throws NoCharException 
	 */
	@RequestMapping(value = "/streamtest/stream/firstChar", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "First Char", notes = "Carrega o primeiro char unico do stream.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Retorna o primeiro char unico do stream."), })
	public @ResponseBody char firstChar(@RequestBody String stream) throws NoCharException {
		
		logger.info("First unique char.");
		
		final Stream streamProcessor = new UniqueStreamImpl(stream);
		return ReadUtil.firstChar(streamProcessor);
	}

}
