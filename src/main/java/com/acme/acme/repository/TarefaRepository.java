package com.acme.acme.repository;

import com.acme.acme.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author diego.nogueira
 */
@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    

}
