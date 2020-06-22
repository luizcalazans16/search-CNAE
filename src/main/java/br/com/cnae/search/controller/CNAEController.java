package br.com.cnae.search.controller;

import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cnae.search.model.CNAE;
import br.com.cnae.search.service.CNAEService;


@RestController
@RequestMapping("/CNAE")
public class CNAEController {

	@Autowired
	private CNAEService service;
	
	
	@GetMapping("/CNAEWithCode")
	public ResponseEntity<?> listCNAEWithCode() throws ParseException {
		List<CNAE> CNAEList = service.listCNAECode();
		return new ResponseEntity<Iterable<CNAE>>(CNAEList, HttpStatus.OK);
	}
	
	@GetMapping("/CNAE-secoes")
	public  ResponseEntity<? > listCNAESections(){
		List<CNAE> CNAEList = service.listCNAESections();
		return new ResponseEntity<Iterable<CNAE>>(CNAEList, HttpStatus.OK);
	}
	
	@GetMapping("/CNAE-grupos")
	public ResponseEntity<?> listCNAEGroups(){
		List<CNAE> CNAEList = service.listCNAEGroups();
		return new ResponseEntity<Iterable<CNAE>>(CNAEList, HttpStatus.OK);
	}
	
	@GetMapping("/CNAE-divisoes")
	public ResponseEntity<?> listCNAEDivisoes(String divisao){
		var response = service.listDivisao(divisao);
		return new ResponseEntity<Iterable<CNAE>>(response, HttpStatus.OK);
	}
	

	
}
