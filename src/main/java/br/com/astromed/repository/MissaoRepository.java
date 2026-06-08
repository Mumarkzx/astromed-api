package br.com.astromed.repository;

import br.com.astromed.entity.Missao;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MissaoRepository implements PanacheRepository<Missao> {
}