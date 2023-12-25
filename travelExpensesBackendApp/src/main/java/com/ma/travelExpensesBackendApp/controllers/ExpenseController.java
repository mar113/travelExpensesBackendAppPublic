package com.ma.travelExpensesBackendApp.controllers;

import com.ma.travelExpensesBackendApp.entities.Expense;
import com.ma.travelExpensesBackendApp.exceptions.ItemNotFoundException;
import com.ma.travelExpensesBackendApp.services.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/expenses")
@AllArgsConstructor
public class ExpenseController implements ExpenseOperations {
    @Autowired
   private ExpenseService service;


    @Override
    public Expense addExpenseItem(@RequestBody Expense expense) throws ItemNotFoundException {
        Expense savedExpense=service.addExpense(expense);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedExpense.getId()).toUri();
        return savedExpense;
    }
    @Override
    public List<Expense> getExpensesList() {
        return service.getAllExpense();
    }

    @Override
    public Expense getExpenseItem(@PathVariable int id) throws ItemNotFoundException {
        return service.getExpenseById(id);
    }
    @Override
    public Expense updateExpenseItemList(@RequestBody Expense expense, @PathVariable int id) throws ItemNotFoundException {
        return service.updateExpenseItem(expense,id);
    }
    @Override
    public void deleteItem(@PathVariable int id){
        service.deleteExpenseItem(id);
    }
}
