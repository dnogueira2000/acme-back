package com.acme.acme.service;

import com.acme.acme.form.ListaForm;
import com.acme.acme.form.TarefaForm;
import com.acme.acme.model.Lista;
import com.acme.acme.model.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.acme.acme.repository.ListaRepository;
import com.acme.acme.repository.TarefaRepository;
import java.util.Objects;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author diego.nogueira
 */
@Service
public class ListaService {
    
    @Autowired
    private ListaRepository listaRepository;
    
    @Autowired
    private TarefaRepository tarefaRepository;
    
    @Transactional
    public void cadastrar(ListaForm listaForm) {
        Lista lista = listaForm.converter(listaForm);
        listaRepository.save(lista);
    }
    
    @Transactional
    public Page<Lista> lista(@RequestParam(required = false) String listaNome, 
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable paginacao) {
        
        if (Objects.isNull(listaNome)) {
            Page<Lista> lista = listaRepository.findAll(paginacao);
            return lista;
        } else {
            Page<Lista> lista = listaRepository.findByListaNomeContains(listaNome, paginacao);
            return lista;
        }
    }

    @Transactional
    public boolean excluir(Long id) {
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        
        if(optional.isPresent()) {
            tarefaRepository.deleteById(id);    
            return true;
        }
        
        return false;
    }
    
    @Transactional
    public Tarefa concluido(@PathVariable Long id, @RequestBody @Valid TarefaForm tarefaForm) {
        
        Optional<Tarefa> optional = tarefaRepository.findById(id);
        Tarefa tarefa = new Tarefa();
        
        if(optional.isPresent()) {
            tarefa = tarefaForm.concluido(id, tarefaRepository);
            
            if(tarefa.getConcluido()) {
                tarefa.setConcluido(Boolean.FALSE);
            } else {
                tarefa.setConcluido(Boolean.TRUE);
            }
            
            return tarefa;
        }
        
        return tarefa;
    }
}
