package br.com.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Cliente extends Pessoa
{
    private String tipoCliente;
    private String email;
}
