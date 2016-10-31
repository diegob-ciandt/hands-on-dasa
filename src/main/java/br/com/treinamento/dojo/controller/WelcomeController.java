package br.com.treinamento.dojo.controller;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.treinamento.dojo.service.MarvelRequestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Autowired
	MarvelRequestSender sender;

	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public String helloWorld() {
		return sender.sendRequest("https://gateway.marvel.com:443/v1/public/characters");
	}

}
