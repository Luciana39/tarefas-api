package com.example.tarefasapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.tarefasapi.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

}
