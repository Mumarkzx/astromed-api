package br.com.astromed.resource;

import br.com.astromed.entity.Missao;
import br.com.astromed.service.MissaoService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/missoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MissaoResource {

    @Inject
    MissaoService service;

    @GET
    public Response listar() {
        List<Missao> missoes = service.listarTodos();
        return Response.ok(missoes).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Missao missao = service.buscarPorId(id);
        if (missao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(missao).build();
    }

    @POST
    public Response salvar(Missao missao) {
        try {
            service.salvar(missao);
            return Response.status(Response.Status.CREATED).entity(missao).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        Missao missao = service.buscarPorId(id);
        if (missao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.deletar(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Missao missao) {
        Missao missaoExistente = service.buscarPorId(id);
        if (missaoExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.atualizar(id, missao);
        return Response.ok(missao).build();
    }
}