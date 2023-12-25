package com.ma.travelExpensesBackendApp.repositories;

import com.ma.travelExpensesBackendApp.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
}
