package com.ms_payment.hr_payroll.integration;

import com.ms_payment.hr_payroll.resources.dto.WorkerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "hr-worker", path = "/api/workers")
public interface WorkerFeignClient {
    @GetMapping("/{id}")
    WorkerDto findById(@PathVariable Long id);
}
