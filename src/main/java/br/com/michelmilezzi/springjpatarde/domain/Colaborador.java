package br.com.michelmilezzi.springjpatarde.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "colaborador_gen")
    @SequenceGenerator(name = "colaborador_gen", sequenceName = "colaborador_id_seq", allocationSize = -1)
    private Integer id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "setor_id", referencedColumnName = "id")
    private Setor setor;

    @ManyToOne()
    @JoinColumn(name = "gerente_id", referencedColumnName = "id")
    private Colaborador gerente;

    @Column(name = "hora_inicial")
    private LocalTime horaInicial;

    @Column(name = "hora_final")
    private LocalTime horaFinal;

    private BigDecimal salario;

    private BigDecimal bonus;

}
