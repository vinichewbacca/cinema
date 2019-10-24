package br.com.edu.ifms.cinema.controller;

import br.com.edu.ifms.cinema.model.Pagamento;
import br.com.edu.ifms.cinema.repositories.PagamentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController
{
    private PagamentoRepository repository;

    public PagamentoController(PagamentoRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/lista-pagamento")
    Collection<Pagamento>pagamentos()
    {
        return repository.findAll();
    }

    @PostMapping("/cad-pagamento")
    ResponseEntity<Pagamento>savePagamento(@RequestBody Pagamento pagamento) throws URISyntaxException
    {
        Pagamento pg = repository.save(pagamento);
        return ResponseEntity.created(new URI("/pagamento/cad-pagamento/"+pg.getIdPagamento())).body(pg);
    }

    @PutMapping("/upd-pagamento/{idPg}")
    ResponseEntity<Pagamento>updatePagamento(@Valid @RequestBody Pagamento pagamento)
    {
        Pagamento pg = repository.save(pagamento);
        return  ResponseEntity.ok().build();
    }

    @DeleteMapping("/del-pagamento/{idPg}")
    ResponseEntity<Pagamento>deletePagamento(@PathVariable @RequestBody Long idPg)
    {
        repository.deleteById(idPg);
        return ResponseEntity.ok().build();
    }
}
