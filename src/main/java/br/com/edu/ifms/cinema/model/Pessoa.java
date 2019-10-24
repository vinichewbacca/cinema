package br.com.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*Anotacoes gera construtores e metodos geters/seters, toString, hash*/
@AllArgsConstructor
@NoArgsConstructor
@Data

/*Anotacoes jpa*/
@Entity
@Inheritance(strategy = InheritanceType.JOINED)/*No bd cria a tabela pai e as filhas*/
public abstract class Pessoa
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPessoa;//no diagram de classe é código
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
}
