package com.ms_payment.hr_payroll.entity;

import jakarta.persistence.Entity;import jakarta.persistence.GeneratedValue;import jakarta.persistence.GenerationType;import jakarta.persistence.Id;import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double dailyIncome;
    private Integer days;

    public double getTotal(){
        return days * dailyIncome;
    }


}
