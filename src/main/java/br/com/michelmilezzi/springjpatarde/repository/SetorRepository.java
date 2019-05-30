package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.MediaSalarial;
import br.com.michelmilezzi.springjpatarde.domain.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

    @Query("SELECT new br.com.michelmilezzi.springjpatarde.domain.MediaSalarial(s, avg(c.salario)) FROM Setor s JOIN s.colaboradores c WHERE s.id = :id GROUP BY s")
    MediaSalarial calcularMediaSalarial(@Param("id") Integer id);

}
