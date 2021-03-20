package br.com.stur.imposto.territorial.api.enums;

public enum TipoContribuinte {
	PESSOA_FISICA(1),
	PESSOA_JURIDICA(2);
	
	private TipoContribuinte(Integer codigo) {
		this.codigo = codigo;
	}
	
	private Integer codigo;
	
	public Integer getCodigo() {
		return codigo;
	}
}
