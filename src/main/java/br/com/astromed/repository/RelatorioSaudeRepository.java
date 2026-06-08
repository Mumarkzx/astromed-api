package br.com.astromed.repository;

import br.com.astromed.entity.RelatorioSaude;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RelatorioSaudeRepository implements PanacheRepository<RelatorioSaude> {
}