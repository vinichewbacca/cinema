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
public class Pagamento
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPagamento;
    private String formaPagamento;
    /*OneToMany significa que existe um relacionamento
     * de um para muitos cascadeType.ALL indica que as alterações
     * na entidade pagamento serão refletidas automaticmente
     * nas entidades relacionadas (imprimirTicket)*/
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPagamento")
    private Collection<ImprimirTicket>idImprimirTicket;

}
