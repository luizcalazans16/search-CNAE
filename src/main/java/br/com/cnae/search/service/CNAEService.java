package br.com.cnae.search.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cnae.search.model.CNAE;

@Service
public class CNAEService {

	public List<CNAE> listCNAECode() throws ParseException {

		final String URL_WEBSERVICE = "https://servicodados.ibge.gov.br/api/v2/cnae/classes";
		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();

			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			String response = sb.toString();

			ObjectMapper mapper = new ObjectMapper();
			String jsonString = response;
			List<CNAE> myObj = mapper.readValue(jsonString,
					mapper.getTypeFactory().constructCollectionType(List.class, CNAE.class));

			return myObj;

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			connection.disconnect();
		}

	}

	public List<CNAE> listCNAESections() {
		final String URL_WEBSERVICE = "https://servicodados.ibge.gov.br/api/v2/cnae/secoes";
		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			String response = sb.toString();
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = response;
			List<CNAE> CNAEList = mapper.readValue(jsonString,
					mapper.getTypeFactory().constructCollectionType(List.class, CNAE.class));
			return CNAEList;

		} catch (IOException ex) {
			throw new RuntimeException(ex);
		} finally {
			connection.disconnect();
		}
	}
	
	public List<CNAE> listCNAEGroups(){
		final String URL_WEBSERVICE = "https://servicodados.ibge.gov.br/api/v2/cnae/grupos";
		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			String response = sb.toString();
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = response;
			List<CNAE> CNAEList = mapper.readValue(jsonString,
					mapper.getTypeFactory().constructCollectionType(List.class, CNAE.class));
			return CNAEList;

		} catch (IOException ex) {
			throw new RuntimeException(ex);
		} finally {
			connection.disconnect();
		}
	}
	
	public List<CNAE> listDivisao(String divisao){
		final String URL_WEBSERVICE = "https://servicodados.ibge.gov.br/api/v2/cnae/divisoes/{divisao}/grupos";
		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			String response = sb.toString();
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = response;
			List<CNAE> CNAEList = mapper.readValue(jsonString,
					mapper.getTypeFactory().constructCollectionType(List.class, CNAE.class));
			return CNAEList;

		} catch (IOException ex) {
			throw new RuntimeException(ex);
		} finally {
			connection.disconnect();
		}
	}
 }
