package com.ma.travelExpensesBackendApp.services;

import com.ma.travelExpensesBackendApp.entities.Expense;
import com.ma.travelExpensesBackendApp.exceptions.ItemNotFoundException;
import com.ma.travelExpensesBackendApp.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    ExpenseRepository expenseRepository;
    @Override
    public Expense addExpense(Expense savedExpense){
        return expenseRepository.save(savedExpense);

    }

    @Override
    public Expense getExpenseById(int id) throws ItemNotFoundException {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(expense.isEmpty()){
            throw new ItemNotFoundException("element introuvable");
        }
        return expense.get();
    }

    @Override
    public List<Expense> getAllExpense() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses;
    }

    @Override
    public void deleteExpenseItem(int id) {
        expenseRepository.deleteById(id);
    }
@Override
    public Expense updateExpenseItem(Expense expense, int id) throws ItemNotFoundException {
        Expense savedExpense = getExpenseById(id);
        savedExpense.setDescription(expense.getDescription());
        savedExpense.setVendor(expense.getVendor());
        savedExpense.setAmount(expense.getAmount());
        return  expenseRepository.save(savedExpense);
    }

}
