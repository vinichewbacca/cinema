package br.com.edu.ifms.cinema.repositories;

import br.com.edu.ifms.cinema.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento,Long>
{

}
