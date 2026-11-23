package com.ms_payment.hr_payroll.services;

import com.ms_payment.hr_payroll.integration.WorkerFeignClient;
import com.ms_payment.hr_payroll.resources.dto.WorkerDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final WorkerFeignClient workerFeignClient;

    @CircuitBreaker(name = "hr-worker", fallbackMethod = "findByIdFallback")
    public WorkerDto buscarWorker(Long id) {
        return workerFeignClient.findById(id);
    }

    private WorkerDto findByIdFallback(Long id, Throwable ex){
        return new WorkerDto(1L, "indisponível", "0");
    }
}
