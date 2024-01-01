package br.com.kbs.service;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.kbs.model.Cep;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

//https://viacep.com.br/ws/01001000/json/
@Path("/ws")
@RegisterRestClient(configKey="cep-api")
public interface ViaCep {
    @GET
	@Path("/{cep}/json/")
	@Produces(MediaType.APPLICATION_JSON)
	public Cep consultar(@PathParam(value = "cep") String cep);

	//Listar CEP por localidade
    //https://viacep.com.br/ws/DF/Brasilia/Aguas/json/
	@GET
	@Path("/{uf}/{cidade}/{bairro}/json/")
	@Produces(MediaType.APPLICATION_JSON)
    public List<Cep> listar(@PathParam(value = "uf") String uf, 
	                        @PathParam(value = "cidade") String cidade, 
							@PathParam(value = "bairro") String bairro);
}