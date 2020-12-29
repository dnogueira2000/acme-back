/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acme.acme.dto;

import com.acme.acme.model.Tarefa;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author diego.nogueira
 */
@Getter
@Setter
public class ListaDTO {
    
    private Long id;
    private String listaNome;
    private List<Tarefa> tarefas;

    public ListaDTO(Long id, String listaNome, List<Tarefa> tarefas) {
        this.id = id;
        this.listaNome = listaNome;
        this.tarefas = tarefas;
    }
    
    
}
