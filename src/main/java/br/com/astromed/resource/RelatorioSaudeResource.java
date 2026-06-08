package br.com.astromed.resource;

import br.com.astromed.dto.RelatorioSaudeDTO;
import br.com.astromed.entity.Missao;
import br.com.astromed.entity.RelatorioSaude;
import br.com.astromed.service.RelatorioSaudeService;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/relatorios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RelatorioSaudeResource {

    @Inject
    RelatorioSaudeService service;

    @GET
    public Response listar() {
        List<RelatorioSaude> relatorios = service.listarTodos();
        return Response.ok(relatorios).build();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") Long id) {
        RelatorioSaude relatorio = service.buscarPorId(id);
        if (relatorio == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(relatorio).build();
    }

    @POST
    public Response salvar(RelatorioSaudeDTO dto) {
        try {
            RelatorioSaude relatorio = new RelatorioSaude();
            relatorio.setFrequenciaCardiaca(dto.frequenciaCardiaca);
            relatorio.setPressaoArterial(dto.pressaoArterial);
            relatorio.setObservacoes(dto.observacoes);

            // Vinculando o Relatório à Missão através do ID que vem no DTO
            if (dto.idMissao != null) {
                Missao missaoRef = new Missao();
                missaoRef.setId(dto.idMissao);
                relatorio.setMissao(missaoRef);
            }

            service.salvar(relatorio);
            return Response.status(Response.Status.CREATED).entity(relatorio).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, RelatorioSaude relatorio) {
        RelatorioSaude relatorioExistente = service.buscarPorId(id);
        if (relatorioExistente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.atualizar(id, relatorio);
        return Response.ok(relatorio).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        RelatorioSaude relatorio = service.buscarPorId(id);
        if (relatorio == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.deletar(id);
        return Response.noContent().build();
    }
}