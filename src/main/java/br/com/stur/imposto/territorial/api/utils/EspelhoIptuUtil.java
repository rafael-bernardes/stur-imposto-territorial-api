package br.com.stur.imposto.territorial.api.utils;

import java.util.Date;

import br.com.stur.imposto.territorial.api.enums.TipoContribuinte;
import br.com.stur.stur.imposto.territorial.api.entities.Contribuinte;
import br.com.stur.stur.imposto.territorial.api.entities.EspelhoIptu;

public class EspelhoIptuUtil {
	public static EspelhoIptu gerarEspelho(TipoContribuinte tipoContribuinte, String documento) {
		EspelhoIptu espelho = new EspelhoIptu();
		
		espelho.setAreaEdificada(new Double("79"));
		espelho.setAreaTerreno(new Double("0"));
		espelho.setContribuinte(gerarContribuinte(tipoContribuinte, documento));
		espelho.setDataProcessamento(new Date());
		espelho.setDesconto(new Double("10"));
		espelho.setImpostoAnual(new Double("579.43"));
		espelho.setMatricula("123456");
		espelho.setMensagemContribuinte("Contribuinte sem pendências. Parabéns!");
		espelho.setObservacoes("Você pode ter desconto no IPTU através do programa sua nota vale desconto. Mais informações em www.bom-destino.gov.br");
		espelho.setTaxaColetaLixo(new Double("327.12"));
		espelho.setTotalAnual(new Double("905.31"));
		espelho.setUtilizacaoImovel("RESIDENCIAL");
		espelho.setValorTributavel(new Double("57942.65"));
		
		return espelho;
	}

	private static Contribuinte gerarContribuinte(TipoContribuinte tipoContribuinte, String documento) {
		Contribuinte contribuinte = new Contribuinte();
		
		if(TipoContribuinte.PESSOA_FISICA.equals(tipoContribuinte)) {
			contribuinte.setTipoPessoa(TipoContribuinte.PESSOA_FISICA.getCodigo());
			contribuinte.setDocumento(documento);
			contribuinte.setBairro("São Lourenço");
			contribuinte.setCep("12345-678");
			contribuinte.setCidade("Bom Destino");
			contribuinte.setEndereco("Rua do Limoeiro");
			contribuinte.setNome("Monteiro Lobato");
			contribuinte.setNumero("239");
		}else {
			contribuinte.setTipoPessoa(TipoContribuinte.PESSOA_JURIDICA.getCodigo());
			contribuinte.setDocumento(documento);
			contribuinte.setBairro("Monte Verde");
			contribuinte.setCep("15645-678");
			contribuinte.setCidade("Bom Destino");
			contribuinte.setEndereco("Rua das Flores");
			contribuinte.setNome("Laticínios Bom Destino Ltda");
			contribuinte.setNumero("239");
		}
		
		return contribuinte;
	}
}