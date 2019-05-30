package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.MediaSalarial;
import br.com.michelmilezzi.springjpatarde.domain.Setor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SetorRepositoryTests {

    @Autowired
    private SetorRepository setorRepository;

    @Test
    public void findAllTests() {

        List<Setor> setores = setorRepository.findAll();

        for (Setor setor : setores) {

            System.out.println("Setor: " + setor.getNome());

        }

    }

    @Test
    public void mediaSalarial() {

        MediaSalarial media = setorRepository.calcularMediaSalarial(1);
        Assertions.assertThat(media.getMediaSalarial()).isGreaterThan(10D);


    }


}
