package br.com.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
public class Assento
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAssento;
    private int poltrona;
    private String fila;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAssento")
    private Collection<Pagamento> idPagamento;
}
