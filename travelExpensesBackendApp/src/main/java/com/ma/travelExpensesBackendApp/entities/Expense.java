package com.ma.travelExpensesBackendApp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "EXPENSE")
@Data
@NoArgsConstructor @AllArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String expenseName;
    private String description;
    private String vendor;
    private double amount;
}
