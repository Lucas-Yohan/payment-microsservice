package com.ms_payment.hr_worker.repository;

import com.ms_payment.hr_worker.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
