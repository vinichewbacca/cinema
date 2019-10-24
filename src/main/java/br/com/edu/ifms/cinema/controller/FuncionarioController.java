package br.com.edu.ifms.cinema.controller;

import br.com.edu.ifms.cinema.model.Funcionario;
import br.com.edu.ifms.cinema.repositories.FuncionarioRepository;


import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/funcionario")
public class FuncionarioController
{
    private FuncionarioRepository repository;

    public FuncionarioController(FuncionarioRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/busca-funcionario-id/{id}")
    ResponseEntity<Funcionario> getFilmeId(@PathVariable(value = "id") Long id) {
        Funcionario c = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionario not found for this id :: " + id));
        return ResponseEntity.ok().body(c);
    }
    @GetMapping("/lista-funcionario")
    Collection<Funcionario> funcionarios()
    {
        return repository.findAll();
    }

    @PostMapping("/cad-funcionario")
    ResponseEntity<Funcionario>saveFuncionario(@RequestBody Funcionario funcionario) throws URISyntaxException
    {
        Funcionario f = repository.save(funcionario);
        return ResponseEntity.created(new URI("/funcionario/cad-funcionario/"+f.getIdPessoa())).body(f);
    }

    @PutMapping("/upd-funcionario/{idFunc}")
    ResponseEntity<Funcionario>updateFuncionario(@Valid @RequestBody Funcionario funcionario)
    {
        Funcionario f = repository.save(funcionario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/del-funcionario/{idFunc}")
    ResponseEntity<Funcionario>deleteFuncionario(@PathVariable @RequestBody Long idFunc)
    {
        repository.deleteById(idFunc);
        return ResponseEntity.ok().build();
    }
}
