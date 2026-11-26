package com.ms_payment.hr_payroll.resources;

import com.ms_payment.hr_payroll.resources.dto.WorkerDto;
import com.ms_payment.hr_payroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentResource {
    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public ResponseEntity<WorkerDto> getWorker(@PathVariable Long id){
        WorkerDto worker = paymentService.buscarWorker(id);
        return ResponseEntity.status(200).body(worker);
    }

    @GetMapping("/health-check")
    public ResponseEntity<String> healthCheck(){
        return ResponseEntity.status(200).body("Health-checked");
    }
}
