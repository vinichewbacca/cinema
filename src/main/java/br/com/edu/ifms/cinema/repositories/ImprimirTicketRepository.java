package br.com.edu.ifms.cinema.repositories;

import br.com.edu.ifms.cinema.model.ImprimirTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImprimirTicketRepository extends JpaRepository<ImprimirTicket, Long>
{

}
