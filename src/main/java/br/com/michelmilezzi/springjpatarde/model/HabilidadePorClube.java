package br.com.michelmilezzi.springjpatarde.model;

import br.com.michelmilezzi.springjpatarde.domain.Clube;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class HabilidadePorClube {

    private Clube clube;
    private Long somaDaHabilidade;

    public HabilidadePorClube(Clube clube, Long somaDaHabilidade) {
        this.clube = clube;
        this.somaDaHabilidade = somaDaHabilidade;
    }
}
