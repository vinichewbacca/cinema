package br.com.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Sala
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSala;
    private String tipoSala;
    private int numero;
    @ManyToOne
    @JoinColumn(name = "idFilme", nullable = false)
    private Filme idFilme;
    @ManyToOne
    @JoinColumn(name = "idAssento", nullable = false)
    private Assento idAssento;
}
