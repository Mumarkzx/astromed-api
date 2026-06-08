package br.com.astromed.resource;

import br.com.astromed.entity.Usuario;
import br.com.astromed.service.UsuarioService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    UsuarioService service;

    @GET
    public Response listar() {
        List<Usuario> usuarios = service.listarTodos();
        return Response.ok(usuarios).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        Usuario usuario = service.buscarPorId(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(usuario).build();
    }

    @POST
    public Response salvar(Usuario usuario) {
        try {
            service.salvar(usuario);
            return Response.status(Response.Status.CREATED).entity(usuario).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        Usuario usuario = service.buscarPorId(id);
        if (usuario == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.deletar(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Usuario usuario) {
        Usuario usuarioExistente = service.buscarPorId(id);
        if (usuarioExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.atualizar(id, usuario);
        return Response.ok(usuario).build();
    }
}