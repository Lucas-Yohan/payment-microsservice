package com.ms_payment.hr_worker.resources;

import com.ms_payment.hr_worker.entity.Worker;
import com.ms_payment.hr_worker.exception.EntityNotFoundException;
import com.ms_payment.hr_worker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerResources {
    private final WorkerRepository workerRepository;
    private String nome = "Ronaldo";

    @GetMapping
    public ResponseEntity<List<Worker>> findAllWorkers(){
        List<Worker> workers = workerRepository.findAll();
        return ResponseEntity.status(200).body(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Worker não encontrado"));
        return ResponseEntity.status(200).body(worker);
    }
}
