package com.ma.travelExpensesBackendApp.controllers;

import com.ma.travelExpensesBackendApp.entities.Expense;
import com.ma.travelExpensesBackendApp.exceptions.ItemNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/")
public interface ExpenseOperations {


    @PostMapping("")
    Expense addExpenseItem(@RequestBody Expense expense) throws ItemNotFoundException;

    @GetMapping("")
    List<Expense> getExpensesList();

    @GetMapping("/{id}")
    Expense getExpenseItem(@PathVariable int id) throws ItemNotFoundException;

    @PutMapping("/edit/{id}")
    Expense updateExpenseItemList(@RequestBody Expense expense, @PathVariable int id) throws ItemNotFoundException;

    @DeleteMapping("/{id}")
    void deleteItem(@PathVariable int id);
}
