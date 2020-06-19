package br.com.cnae.search.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CNAE {

	@JsonProperty("id")
	private String id;

	@JsonProperty("descricao")
	private String descricao;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "CNAEDto{" + "id='" + id + ", descricao= " + descricao + '}';

	}

}
