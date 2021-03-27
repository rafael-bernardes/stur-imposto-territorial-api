package br.com.stur.imposto.territorial.api.enums;

public enum TipoPessoa {
	PESSOA_FISICA(1),
	PESSOA_JURIDICA(2),
	PESSOA_RURAL(3);
	
	private TipoPessoa(Integer codigo) {
		this.codigo = codigo;
	}
	
	private Integer codigo;
	
	public Integer getCodigo() {
		return codigo;
	}
}
