package br.com.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Sessao
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSessao;
    private LocalTime horario;
    private Sala idSala;
    @ManyToOne
    @JoinColumn(name = "idFilme", nullable = false)
    private Filme idFilme;
    @ManyToOne
    @JoinColumn(name = "idPessoa", nullable = false)
    private Pessoa idPessoa;
}
