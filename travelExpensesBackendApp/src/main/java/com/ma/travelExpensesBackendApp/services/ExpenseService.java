package com.ma.travelExpensesBackendApp.services;

import com.ma.travelExpensesBackendApp.entities.Expense;
import com.ma.travelExpensesBackendApp.exceptions.ItemNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ExpenseService {

   Expense addExpense(Expense expense) throws ItemNotFoundException;
    Expense getExpenseById(int id) throws ItemNotFoundException;
    List<Expense> getAllExpense();
    void deleteExpenseItem(int id);

    Expense updateExpenseItem(Expense expense, int id) throws ItemNotFoundException;
}
