package br.com.kbs;

import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.kbs.model.Cep;
import br.com.kbs.service.ViaCep;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/cep")
public class CepResource {
    
    @Inject
    @RestClient
    ViaCep viaCep;

    @GET
    @Path("/{cep}")
    @Produces(MediaType.APPLICATION_JSON)    
    public Cep cep(@PathParam(value = "cep") String cep) {
        return viaCep.consultar(cep);
    }

    @GET
    @Path("/{uf}/{cidade}/{bairro}")
    @Produces(MediaType.APPLICATION_JSON)    
    public List<Cep> cep(@PathParam(value = "uf") String uf,
                   @PathParam(value = "cidade") String cidade,
                   @PathParam(value = "bairro") String bairro) {
        return viaCep.listar(uf, cidade, bairro);
    }
}
