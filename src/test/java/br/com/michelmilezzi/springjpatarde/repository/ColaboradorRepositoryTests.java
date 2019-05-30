package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.Colaborador;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ColaboradorRepositoryTests {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Test
    @Transactional
    public void testFindAll() {

        List<Colaborador> colaboradores = colaboradorRepository.findAll();

        for (Colaborador colaborador : colaboradores) {
            System.out.println(String.format("%s -> %s", colaborador.getNome(), colaborador.getSetor() != null ? colaborador.getSetor().getNome() : "Sem Setor" ));
        }

        Assertions.assertThat(colaboradores.size()).isEqualTo(11);

    }

    @Test
    public void testFindByColaboradorId() {

        Colaborador colaborador = colaboradorRepository.findByColaboradorId(1);
        Assertions.assertThat(colaborador.getNome()).isEqualTo("Trump");

    }

    @Test
    public void meiaSalariaTest() {
        BigDecimal mediaSalarial = colaboradorRepository.mediaSalarial();
        Assertions.assertThat(mediaSalarial).isGreaterThan(BigDecimal.TEN);
    }


}
