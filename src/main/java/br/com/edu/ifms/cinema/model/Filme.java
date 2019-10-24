package br.com.edu.ifms.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@AllArgsConstructor /*cria um construtor com todos os argumentos*/
@NoArgsConstructor/*cria um construtor sem argumentos*/
@Data/*cria todos os getter e setters, hash e tostring*/

@Entity/*sinaliza que é uma tabela do bd*/
public class Filme
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String titulo;
    private String duracao;
    private  String genero;
    private int classificacao; /*0 livre e 5 adulto*/

}
