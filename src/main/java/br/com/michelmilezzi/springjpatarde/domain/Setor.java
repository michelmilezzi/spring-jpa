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
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "setor_gen")
    @SequenceGenerator(name = "setor_gen", sequenceName = "setor_id_seq")
    private Integer id;

    private String nome;

    @OneToMany(mappedBy = "setor")
    private List<Colaborador> colaboradores;

}
