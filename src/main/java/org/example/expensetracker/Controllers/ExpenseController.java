package org.example.expensetracker.Controllers;

import org.example.expensetracker.Entities.Expense;
import org.example.expensetracker.Services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    // creating the expense

    @PostMapping
    public Expense createExpense(@RequestBody Expense expense){

        return expenseService.saveExpense(expense);
    }

    // read operations here

    // getting all the expenses here

    @GetMapping
    public List<Expense> findAllExpenses(){
        return expenseService.findAllExpenses();
    }

    // getting the specific operations by the id of the expense.

    @GetMapping("/{expenseId}")
    public Optional<Expense> findByIdExpense(@PathVariable int expenseId){
        return expenseService.findById(expenseId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Expense> findByCategory(@PathVariable int categoryId){
        return expenseService.findByCategory(categoryId);
    }

    @GetMapping("/user/{userId}")
    public List<Expense> findByUser(@PathVariable int userId){
        return expenseService.findByUser(userId);
    }
    // updating the expense

    @PutMapping("/{expenseId}")
    public Expense updateExpense(@RequestBody Expense expense,@PathVariable int expenseId){
        return expenseService.updateExpense(expense,expenseId);
    }

    // deleting the expense possible
    @DeleteMapping("/{expenseId}")
    public void deleteExpense(@PathVariable int expenseId){
        expenseService.deleteExpense(expenseId);
    }

}
