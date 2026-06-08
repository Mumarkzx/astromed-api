package br.com.astromed.service;

import br.com.astromed.entity.Missao;
import br.com.astromed.repository.MissaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class MissaoService {

    @Inject
    MissaoRepository repository;

    public List<Missao> listarTodos() {
        return repository.listAll();
    }

    public Missao buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void salvar(Missao missao) {
        repository.persist(missao);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void atualizar(Long id, Missao missaoAtualizada) {
        Missao missaoExistente = repository.findById(id);


        if (missaoExistente != null) {
            missaoExistente.setNomeMissao(missaoAtualizada.getNomeMissao());
            missaoExistente.setDestino(missaoAtualizada.getDestino());
            missaoExistente.setStatus(missaoAtualizada.getStatus());

        }
    }
}