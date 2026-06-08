package br.com.astromed.service;

import br.com.astromed.entity.RelatorioSaude;
import br.com.astromed.repository.RelatorioSaudeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RelatorioSaudeService {

    @Inject
    RelatorioSaudeRepository repository;

    public List<RelatorioSaude> listarTodos() {
        return repository.listAll();
    }

    public RelatorioSaude buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void salvar(RelatorioSaude relatorio) {
        repository.persist(relatorio);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void atualizar(Long id, RelatorioSaude relatorioAtualizado) {
        RelatorioSaude relatorio = repository.findById(id);

        if (relatorio != null) {
            relatorio.setFrequenciaCardiaca(relatorioAtualizado.getFrequenciaCardiaca());
            relatorio.setPressaoArterial(relatorioAtualizado.getPressaoArterial());
            relatorio.setObservacoes(relatorioAtualizado.getObservacoes());
        }
    }
}