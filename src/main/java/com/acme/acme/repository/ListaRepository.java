package com.acme.acme.repository;

import com.acme.acme.model.Lista;
import com.acme.acme.model.Tarefa;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 *
 * @author diego.nogueira
 */
@Repository
public interface ListaRepository extends JpaRepository<Lista, Long>{
    
    public Page<Lista> findByListaNomeContains(@Param("listaNome") String listaNome, Pageable paginacao);
    
    @Query("SELECT l FROM Lista l WHERE l.listaNome = :listaNome")
    List<Lista> carregarPorNome(@Param("listaNome") String nome, Pageable paginacao);
    
}