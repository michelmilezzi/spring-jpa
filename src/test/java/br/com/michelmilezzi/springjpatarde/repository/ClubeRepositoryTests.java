package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.Clube;
import static org.assertj.core.api.Assertions.*;

import br.com.michelmilezzi.springjpatarde.domain.Jogador;
import br.com.michelmilezzi.springjpatarde.model.HabilidadePorClube;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClubeRepositoryTests {

    @Autowired
    private ClubeRepository clubeRepository;

    @Test
    @Transactional
    public void findAllTest() {

        List<Clube> clubes = clubeRepository.findAll(); //SELECT * FROM clube

        for (Clube clube :  clubes) {
            System.out.println(clube);
            for (Jogador jogador : clube.getJogadores()) {//SELECT * FROM jogador WHERE clube_id = :id
                System.out.println(jogador);
            }
        }

        assertThat(clubes.size()).isEqualTo(3);

    }

    @Test
    public void somaHabilidadeDosJogadoresPorClube() {

        List<HabilidadePorClube> listaDeHabilidadePorClube = clubeRepository.somaHabilidadePorClube();

        for(HabilidadePorClube habilidadePorClube : listaDeHabilidadePorClube) {
            System.out.println("Clube: " + habilidadePorClube.getClube().getNome() + " - " + habilidadePorClube.getSomaDaHabilidade());
        }

        assertThat(listaDeHabilidadePorClube.size()).isEqualTo(3);

    }


}
