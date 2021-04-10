package br.gov.bom_destino.stur_imposto_territorial_api.rest;

import java.io.IOException;
import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.gov.bom_destino.stur_imposto_territorial_api.entities.EspelhoIptu;
import br.gov.bom_destino.stur_imposto_territorial_api.enums.TipoPessoa;
import br.gov.bom_destino.stur_imposto_territorial_api.utils.EspelhoIptuUtil;

@Path("espelhos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ImpostoTerritorialResource implements Serializable {

	private static final long serialVersionUID = 1L;

	@GET
	public Response getImpostoTerritorial(@QueryParam("documento") String documento, @QueryParam("tipo-pessoa") Integer tipoPessoa) throws IllegalArgumentException, NullPointerException, IOException {
		if(documento == null || documento.length() == 0 || (documento.length() != 11 && documento.length() != 14)) {
			return Response.status(Status.BAD_REQUEST.getStatusCode(), "Documento inválido").build(); 
		}else if(tipoPessoa == null || tipoPessoa == 0) {
			return Response.status(Status.BAD_REQUEST.getStatusCode(), "Tipo de pessoa inválido").build();
		}
		
		EspelhoIptu espelho;
		
		switch (tipoPessoa) {
		case 1:
			espelho = EspelhoIptuUtil.gerarEspelho(TipoPessoa.PESSOA_FISICA, documento);
			break;
		case 2:
			espelho = EspelhoIptuUtil.gerarEspelho(TipoPessoa.PESSOA_JURIDICA, documento);
			break;
		default:
			espelho = new EspelhoIptu();
			break;
		}
		
		return Response.ok().entity(espelho).build();
	}
}