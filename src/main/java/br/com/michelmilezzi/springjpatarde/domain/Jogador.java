package br.com.michelmilezzi.springjpatarde.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jogador_gen")
    @SequenceGenerator(name = "jogador_gen", sequenceName = "jogador_id_seq", allocationSize = -1)
    private Integer id;

    private String nome;

    private Integer habilidade;

    @ManyToOne
    @JoinColumn(name = "clube_id", referencedColumnName = "id")
    private Clube clube;

    @Override
    public String toString() {
        return String.format("-----------> %s: %d", nome, habilidade);
    }

}
