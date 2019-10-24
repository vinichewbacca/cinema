package br.com.edu.ifms.cinema.controller;

import br.com.edu.ifms.cinema.model.Assento;
import br.com.edu.ifms.cinema.repositories.AssentoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/assento")
public class AssentoController
{
    private AssentoRepository repository;

    /*método construtor*/
    public AssentoController(AssentoRepository repository)
    {
        this.repository = repository;
    }

    /*chama o método paralistar todos*/
    @GetMapping("/listar-assentos")
    Collection<Assento>assentos()
    {
        return repository.findAll();
    }

    @PostMapping("/cad-assento")
    ResponseEntity<Assento> saveAssento(@RequestBody Assento assento) throws URISyntaxException
    {
        Assento a = repository.save(assento);

        return ResponseEntity.created(new URI("/assento/cad-assento/"+a.getIdAssento())).body(a);
    }

    @PutMapping("/upd-assento/{idAss}")
    ResponseEntity<Assento>updateAssento(@Valid @RequestBody Assento assento)
    {
        Assento a = repository.save(assento);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/del-assento/{idAss}")
    ResponseEntity<Assento>deleteAssento(@PathVariable Long idAss)
    {
        repository.deleteById(idAss);
        return ResponseEntity.ok().build();
    }
}
