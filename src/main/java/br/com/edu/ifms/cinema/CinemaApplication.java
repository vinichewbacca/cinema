package br.com.edu.ifms.cinema;

import br.com.edu.ifms.cinema.model.Filme;
import br.com.edu.ifms.cinema.repositories.FilmeRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CinemaApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(CinemaApplication.class, args);
    }

    /*@Bean
    ApplicationRunner init (FilmeRepository filme)
    {
        return args->
        {
            Stream.of("Armageddon", "Titanic","Blade Runner","Piratinhas Serelepes").forEach(titulo ->
            {
                Filme f = new Filme();
                f.setTitulo(titulo);
                filme.save(f);
            });
        };

    }*/

}
