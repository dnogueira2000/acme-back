package com.acme.acme.form;

import com.acme.acme.model.Tarefa;
import com.acme.acme.repository.TarefaRepository;
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
public class TarefaForm {
    
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

    public Tarefa concluido(Long id, TarefaRepository tarefaRepository) {
        Tarefa tarefa = tarefaRepository.getOne(id);
        
        return tarefa;
    }
}
