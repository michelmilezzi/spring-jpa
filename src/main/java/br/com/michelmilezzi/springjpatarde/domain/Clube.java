package br.com.michelmilezzi.springjpatarde.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Clube {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clube_gen")
    @SequenceGenerator(name = "clube_gen", sequenceName = "clube_id_seq", allocationSize = -1)
    private Integer id;

    private String nome;

    @Column(name = "quantidade_titulos_nacionais")
    private Integer quantidadeDeTitulosNacionais;

    @OneToMany(mappedBy = "clube")
    private List<Jogador> jogadores;

    @Override
    public String toString() {
        return String.format("%s. Títulos: %d", nome, quantidadeDeTitulosNacionais);
    }

}
