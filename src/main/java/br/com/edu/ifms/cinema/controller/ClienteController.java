package br.com.edu.ifms.cinema.controller;

import br.com.edu.ifms.cinema.model.Cliente;
import br.com.edu.ifms.cinema.repositories.ClienteRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/cliente")
public class ClienteController
{
    private ClienteRepository repository;

    public ClienteController(ClienteRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/busca-cliente-id/{idcli}")
    ResponseEntity<Cliente> getFilmeId(@PathVariable(value = "idcli") Long idcli) {
        Cliente c = repository.findById(idcli)
                .orElseThrow(() -> new ResourceNotFoundException("Filme not found for this id :: " + idcli));
        return ResponseEntity.ok().body(c);
    }

    @GetMapping("/listar-clientes")
    Collection<Cliente>clientes()
    {
        return repository.findAll();
    }

    @PostMapping("/cad-cliente")
    ResponseEntity<Cliente>saveCliente(@RequestBody Cliente cliente) throws URISyntaxException
    {
        Cliente c = repository.save(cliente);
        return ResponseEntity.created(new URI("/cliente/cad-cliente/"+c.getIdPessoa())).body(c);
    }

    @PutMapping("/upd-cliente/{idCli}")
    ResponseEntity<Cliente>updateCliente(@Valid @RequestBody Cliente cliente)
    {
        Cliente c = repository.save(cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/del-cliente/{idCli}")
    ResponseEntity<Cliente>deleteCliente(@PathVariable Long idCli)
    {
        repository.deleteById(idCli);
        return ResponseEntity.ok().build();
    }
}
