package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.Clube;
import br.com.michelmilezzi.springjpatarde.model.HabilidadePorClube;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClubeRepository extends JpaRepository<Clube, Integer> {

//    SELECT c.nome, sum(j.habilidade) as total_habilidade FROM clube c JOIN jogador j ON (c.id = j.clube_id) GROUP BY c.nome ORDER BY 2 DESC;
    @Query("SELECT new br.com.michelmilezzi.springjpatarde.model.HabilidadePorClube(c, sum(j.habilidade)) FROM Clube c JOIN c.jogadores j GROUP BY c")
    List<HabilidadePorClube> somaHabilidadePorClube();

}
