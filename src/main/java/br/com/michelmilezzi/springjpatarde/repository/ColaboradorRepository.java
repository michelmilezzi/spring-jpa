package br.com.michelmilezzi.springjpatarde.repository;

import br.com.michelmilezzi.springjpatarde.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    @Query(value = "SELECT c FROM Colaborador c JOIN FETCH c.setor where c.id = :id")
    Colaborador findByColaboradorId(@Param("id") Integer id);


    @Query(value = "SELECT avg(c.salario) FROM Colaborador c")
    BigDecimal mediaSalarial();

}
