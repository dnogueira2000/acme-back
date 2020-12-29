package com.acme.acme.dto;

import com.acme.acme.model.Tarefa;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author diego.nogueira
 */
@Getter
@Setter
public class TarefaDTO {
    
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
    
     public TarefaDTO(Tarefa tarefa) {
        this.id = tarefa.getId();
        this.tarefa = tarefa.getTarefa();
        this.dataCadastro = tarefa.getDataCadastro();
        this.dataAtualizacao = tarefa.getDataAtualizacao();
        this.concluido = tarefa.getConcluido();
        this.dataTarefa = tarefa.getDataTarefa();
    }
}
