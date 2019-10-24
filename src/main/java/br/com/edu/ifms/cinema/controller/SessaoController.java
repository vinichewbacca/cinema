package br.com.edu.ifms.cinema.controller;

import br.com.edu.ifms.cinema.model.Sessao;
import br.com.edu.ifms.cinema.repositories.SessaoRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sessao")
public class SessaoController
{
    private SessaoRepository repository;

    public SessaoController(SessaoRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/busca-sessao-id/{id}")
    ResponseEntity<Sessao> getFilmeId(@PathVariable(value = "id") Long id) {
        Sessao c = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario not found for this id :: " + id));
        return ResponseEntity.ok().body(c);
    }
    @GetMapping("/lista-sessao")
    Collection<Sessao>sessoes()
    {
        return repository.findAll();
    }

    @PostMapping("/cad-sessao")
    ResponseEntity<Sessao>saveSessao(@RequestBody Sessao sessao) throws URISyntaxException
    {
        Sessao s = repository.save(sessao);
        return ResponseEntity.created(new URI("/sessao/cad-sessao/"+s.getIdSessao())).body(s);
    }

    @PutMapping("/upd-sessao/{idSes}")
    ResponseEntity<Sessao>updateSessao(@Valid @RequestBody Sessao sessao)
    {
        Sessao s = repository.save(sessao);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/del-sessao/{idSes}")
    ResponseEntity<Sessao>deleteSessao(@PathVariable @RequestBody Long idSes)
    {
        repository.deleteById(idSes);
        return ResponseEntity.ok().build();
    }
}
