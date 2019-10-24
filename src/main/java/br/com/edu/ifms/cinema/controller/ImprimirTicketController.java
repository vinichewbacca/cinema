package br.com.edu.ifms.cinema.controller;

import br.com.edu.ifms.cinema.model.ImprimirTicket;
import br.com.edu.ifms.cinema.repositories.ImprimirTicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/ticket")
public class ImprimirTicketController
{
    private ImprimirTicketRepository repository;

    public ImprimirTicketController(ImprimirTicketRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/lista-tickets")
    Collection<ImprimirTicket>listaTickets()
    {
        return repository.findAll();
    }

    @PostMapping("/cad-ticket")
    ResponseEntity<ImprimirTicket>saveTicket(@RequestBody ImprimirTicket ticket) throws URISyntaxException
    {
        ImprimirTicket t = repository.save(ticket);
        return ResponseEntity.created(new URI("/ticket/cad-ticket/"+t.getIdImprimirTicket())).body(t);
    }

    @PutMapping("/upd-ticket/{idTic}")
    ResponseEntity<ImprimirTicket>updateTicket(@Valid @RequestBody ImprimirTicket ticket)
    {
        ImprimirTicket t = repository.save(ticket);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/del-ticket/{idTic}")
    ResponseEntity<ImprimirTicket>deleteTicket(@PathVariable @RequestBody Long idTic)
    {
        repository.deleteById(idTic);
        return ResponseEntity.ok().build();
    }
}
