package br.com.edu.ifms.cinema.controller;

import br.com.edu.ifms.cinema.model.Filme;
import br.com.edu.ifms.cinema.repositories.FilmeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/filme")/*Entiti point*/
public class FilmeControler
{
    private FilmeRepository repository;
    private Logger log = LoggerFactory.getLogger(FilmeRepository.class);

    /*Método construtor*/
    public FilmeControler(FilmeRepository repository)
    {
        this.repository = repository;
    }

    /*serve para chamar o método de listagem todo*/
    @GetMapping("/listar-filmes")
    Collection<Filme>filmes()
    {
        return repository.findAll();
    }

    @GetMapping("/busca-filme-id/{idf}")
    ResponseEntity<Filme> getFilmeId(@PathVariable(value = "idf") Long idf) {
        Filme filme = repository.findById(idf)
                .orElseThrow(() -> new ResourceNotFoundException("Filme not found for this id :: " + idf));
        return ResponseEntity.ok().body(filme);
    }

    @PostMapping("/cad-filme")
    ResponseEntity<Filme> saveFilme(@RequestBody Filme filme) throws URISyntaxException
    {
        Filme f1 = repository.save(filme);

        /*Retorna a mensagem para o corpo da pagina cria um novo objeto filme
        * retornando uma uri com os dados do filmes preenchidos
        * URI como resposta*/
        return ResponseEntity.created(new URI("/filme/cad-filme/"+ f1.getId())).body(f1);
    }

    @PutMapping("/upd-filme/{idf}")
    ResponseEntity<Filme> updateFilme(@Valid @RequestBody Filme filme)
    {
        Filme f1 = repository.save(filme);
        /*Retorna um status codigo 200 que significa sucesso*/
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/del-filme/{idf}")
    ResponseEntity<Filme> deleteFilme(@PathVariable Long idf)
    {
        repository.deleteById(idf);
        log.warn("Deletando filme.....");
        return ResponseEntity.ok().build();
    }

}
