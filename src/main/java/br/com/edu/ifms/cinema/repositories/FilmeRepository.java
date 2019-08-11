package br.com.edu.ifms.cinema.repositories;

import br.com.edu.ifms.cinema.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository <Filme, Long>
{

}
