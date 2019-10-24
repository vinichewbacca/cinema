package br.com.edu.ifms.cinema.controller;

import br.com.edu.ifms.cinema.model.Sala;
import br.com.edu.ifms.cinema.repositories.SalaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/sala")
public class SalaController
{
    private SalaRepository repository;

    public SalaController(SalaRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/lista-salas")
    Collection<Sala>salas()
    {
        return repository.findAll();
    }

    @PostMapping("/cad-sala")
    ResponseEntity<Sala>saveSala(@RequestBody Sala sala) throws URISyntaxException
    {
        Sala s = repository.save(sala);
        return ResponseEntity.created(new URI("/sala/cad-sala/"+s.getIdSala())).body(s);
    }

    @PutMapping("/upd-sala/{idSal}")
    ResponseEntity<Sala>updateSala(@Valid @RequestBody Sala sala)
    {
        Sala s = repository.save(sala);
        return  ResponseEntity.ok().build();
    }

    @DeleteMapping("/del-sala/{idSal}")
    ResponseEntity<Sala>deleteSala(@PathVariable @RequestBody Long idSal)
    {
        repository.deleteById(idSal);
        return ResponseEntity.ok().build();
    }
}
