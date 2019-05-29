package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.Usuario;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void insercaoDeUsuarioTest() {

        Usuario usuario = new Usuario();
        usuario.setEmail("caco@hotmail.com");
        usuario.setNome("Caco");

        usuarioRepository.save(usuario);
        List<Usuario> usuarios = usuarioRepository.findByNomeContaining(usuario.getNome());
        Assertions.assertThat(usuarios.size()).isEqualTo(1);

    }

    @Test
    public void insercaoDeVariosUsuariosTest() {

        Usuario usuario = new Usuario();
        usuario.setEmail("caco@hotmail.com");
        usuario.setNome("Caco");

        usuarioRepository.save(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.setEmail("chiquinha@gmail.com");
        usuario2.setNome("chiquinha");

        usuarioRepository.save(usuario2);

        List<Usuario> usuarios = usuarioRepository.findByEmailEndingWith("@hotmail.com");
        Assertions.assertThat(usuarios.size()).isEqualTo(1);
        Assertions.assertThat(usuarios.get(0).getNome()).isEqualTo("Caco");

    }


    @After
    public void tearDown() {
        usuarioRepository.deleteAll();
    }

}
