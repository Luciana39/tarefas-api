package com.example.tarefasapi.controller;

import com.example.tarefasapi.model.Tarefa;
import com.example.tarefasapi.repository.TarefaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Tarefa criar(@RequestBody Tarefa tarefa) {
        return repository.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        return repository.findById(id).map(tarefa -> {
            tarefa.setNome(tarefaAtualizada.getNome());
            tarefa.setDataEntrega(tarefaAtualizada.getDataEntrega());
            tarefa.setResponsavel(tarefaAtualizada.getResponsavel());
            return repository.save(tarefa);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
