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
    private String horario;
    private String sala;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idFilme", nullable = false)
    private Filme idFilme;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "idPessoa", nullable = false)
    private Cliente idCliente;
}
