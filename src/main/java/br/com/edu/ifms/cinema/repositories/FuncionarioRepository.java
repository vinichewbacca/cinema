package br.com.edu.ifms.cinema.repositories;

import br.com.edu.ifms.cinema.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>
{

}
