package br.com.cnae.search.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class ConnectionService {
	
	public void connectToWebService(String URL_WEBSERVICE) {
		URL_WEBSERVICE = null;

		HttpURLConnection connection = null;
		try {
			URL url = new URL(URL_WEBSERVICE);
			connection = (HttpURLConnection) url.openConnection();

		} catch (IOException ex) {
			throw new RuntimeException(ex);
		} finally {
			connection.disconnect();
		}
	}
}
