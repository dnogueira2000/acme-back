package com.acme.acme.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author diego.nogueira
 */
@Entity
@Getter
@Setter
@Table(name = "tarefa")
public class Tarefa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String tarefa;
    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataCadastro;
    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataAtualizacao;
    
    private Boolean concluido;
    
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataTarefa;

    public Tarefa() {
    }

    public Tarefa(Long id, String tarefa, Date dataCadastro, Date dataAtualizacao, Boolean concluido, Date dataTarefa) {
        this.id = id;
        this.tarefa = tarefa;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.concluido = concluido;
        this.dataTarefa = dataTarefa;
    }

    public Tarefa(String tarefa, Date dataCadastro, Date dataAtualizacao, Boolean concluido, Date dataTarefa) {
        this.tarefa = tarefa;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
        this.concluido = concluido;
        this.dataTarefa = dataTarefa;
    }
    
}
