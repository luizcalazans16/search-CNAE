package br.com.cnae.search.controller;

import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cnae.search.model.CNAE;
import br.com.cnae.search.service.CNAEService;

@RequestMapping("/CNAE")
@RestController
public class Controller {

	@Autowired
	private CNAEService service;
	
	
	@GetMapping("/CNAEWithCode")
	public List<CNAE> getCNAEWithCode() throws ParseException {
		return service.getCNAECode();
	}
	
	@GetMapping("/CNAE-secoes")
	public List<CNAE> getCNAESections(){
		return service.getCNAESections();
	}
	
}
