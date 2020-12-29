package com.acme.acme.form;

import com.acme.acme.model.Lista;
import com.acme.acme.model.Tarefa;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author diego.nogueira
 */
@Getter
@Setter
public class ListaForm {
    
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String listaNome;
    
    @NotNull
    @NotEmpty
    private List<Tarefa> tarefas;
    
    public Lista converter(ListaForm listaForm) {
        Lista lista = new Lista(listaForm.getListaNome(), listaForm.getTarefas());

        return lista;
    }
}
