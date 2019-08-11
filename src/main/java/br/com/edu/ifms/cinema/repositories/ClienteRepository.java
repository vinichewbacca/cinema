package br.com.edu.ifms.cinema.repositories;

import br.com.edu.ifms.cinema.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{

}
