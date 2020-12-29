package com.acme.acme.controller;

import com.acme.acme.dto.ListaDTO;
import com.acme.acme.dto.TarefaDTO;
import com.acme.acme.form.ListaForm;
import com.acme.acme.form.TarefaForm;
import com.acme.acme.model.Lista;
import com.acme.acme.model.Tarefa;
import com.acme.acme.service.ListaService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.acme.acme.repository.ListaRepository;
import java.util.Objects;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author diego.nogueira
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/listas")
public class ListaController {
    
    @Autowired
    ListaRepository listaRepository;
    
    @Autowired
    ListaService listaService;
    
    @PostMapping
    public ResponseEntity<ListaDTO> cadastrar(@RequestBody @Valid ListaForm listaForm, 
            UriComponentsBuilder uriComponentsBuilder) {
     
        listaService.cadastrar(listaForm);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    
    @GetMapping
    public Page<Lista> lista(@RequestParam(required = false) String listaNome, 
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable paginacao){
        
        return listaService.lista(listaNome, paginacao);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity excluir(@PathVariable Long id) {
        boolean exclui = listaService.excluir(id);
        
        if(exclui) {
            return ResponseEntity.ok().build();
        }
        
        return new ResponseEntity("Id nao encontrado.", HttpStatus.NOT_ACCEPTABLE);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity concluido(@PathVariable Long id, @RequestBody @Valid TarefaForm tarefaForm) {
        Tarefa tarefa = listaService.concluido(id, tarefaForm);
        
        if(Objects.nonNull(tarefa.getId())) {
            return ResponseEntity.ok(new TarefaDTO(tarefa));
        }
        
          return new ResponseEntity("Problema ao atualizar.", HttpStatus.NOT_ACCEPTABLE);
    }
}
