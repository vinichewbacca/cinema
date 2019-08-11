package br.com.edu.ifms.cinema.repositories;

import br.com.edu.ifms.cinema.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoRepository extends JpaRepository<Sessao, Long>
{

}
