package com.ms_payment.hr_worker.resources;

import com.ms_payment.hr_worker.entity.Worker;
import com.ms_payment.hr_worker.exception.EntityNotFoundException;
import com.ms_payment.hr_worker.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
@Slf4j
public class WorkerResources {
    private final WorkerRepository workerRepository;
    @Value("${test-config}")
    private String testConfig;

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

    @GetMapping("/config")
    public ResponseEntity<Void> getConfig(){
        log.info("CONFIG SERVER{}", testConfig);
        return ResponseEntity.ok().build();
    }
}
