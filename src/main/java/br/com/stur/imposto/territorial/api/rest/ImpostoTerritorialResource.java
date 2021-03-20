package br.com.stur.imposto.territorial.api.rest;

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

import br.com.stur.imposto.territorial.api.enums.TipoContribuinte;
import br.com.stur.imposto.territorial.api.utils.EspelhoIptuUtil;
import br.com.stur.stur.imposto.territorial.api.entities.EspelhoIptu;

@Path("espelhos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ImpostoTerritorialResource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GET
	public Response getImpostoTerritorial(@QueryParam("documento") String documento) throws IllegalArgumentException, NullPointerException, IOException {
		if(documento.length() == 0 || (documento.length() != 11 && documento.length() != 14)) {
			return Response.status(Status.BAD_REQUEST.getStatusCode(), "Documento inválido").build(); 
		}
		
		EspelhoIptu espelho;
		
		if(documento.length() == 11) {
			espelho = EspelhoIptuUtil.gerarEspelho(TipoContribuinte.PESSOA_FISICA, documento);
		}else {
			espelho = EspelhoIptuUtil.gerarEspelho(TipoContribuinte.PESSOA_JURIDICA, documento);
		}
		
		return Response.ok().entity(espelho).build();
	}
}