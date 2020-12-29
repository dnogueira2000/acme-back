package com.acme.acme.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author diego.nogueira
 */
@Entity
@Getter
@Setter
@Table(name = "lista")
public class Lista implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String listaNome;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="lista_id")
    private List<Tarefa> tarefas;

    public Lista() {
    }

    public Lista(String listaNome, List<Tarefa> tarefas) {
        this.listaNome = listaNome;
        this.tarefas = tarefas;
    }

    public Lista(Long id, String listaNome, List<Tarefa> tarefas) {
        this.id = id;
        this.listaNome = listaNome;
        this.tarefas = tarefas;
    }
    
}
