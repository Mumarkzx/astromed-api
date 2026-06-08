package br.com.astromed.service;

import br.com.astromed.entity.Usuario;
import br.com.astromed.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository repository;

    public List<Usuario> listarTodos() {
        return repository.listAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public void salvar(Usuario usuario) {
        repository.persist(usuario);
    }

    @Transactional
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void atualizar(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = repository.findById(id);

        if (usuario != null) {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setFuncao(usuarioAtualizado.getFuncao());
        }
    }
}