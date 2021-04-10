package br.gov.bom_destino.stur_imposto_territorial_api.enums;

public enum TipoPessoa {
	PESSOA_FISICA(1),
	PESSOA_JURIDICA(2);
	
	private TipoPessoa(Integer codigo) {
		this.codigo = codigo;
	}
	
	private Integer codigo;
	
	public Integer getCodigo() {
		return codigo;
	}
}
