package org.example.expensetracker.Services;

import org.example.expensetracker.Controllers.UserController;
import org.example.expensetracker.Entities.Category;
import org.example.expensetracker.Entities.Expense;
import org.example.expensetracker.Entities.User;
import org.example.expensetracker.dao.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense saveExpense(Expense expense) {

        Optional<User> user = userService.findByIdUser(expense.getUser().getId());
        Optional<Category> category = categoryService.findByIdCategory(expense.getCategory().getId());
        User user1 = user.orElse(null);
        Category category1 = category.orElse(null);
        Expense newexpense = new Expense();
        newexpense.setName(expense.getName());
        newexpense.setAmount(expense.getAmount());
        newexpense.setDate(expense.getDate());
        newexpense.setUser(user1);
        newexpense.setCategory(category1);

        return expenseRepository.save(newexpense);
    }


    public List<Expense> findAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> findById(int expenseId) {
        return expenseRepository.findById(expenseId);
    }

    public Expense updateExpense(Expense expense, int expenseId) {
        Expense existingExpense = expenseRepository.findById(expenseId).orElse(null);
        if (existingExpense != null) {
            existingExpense.setName(expense.getName());
            existingExpense.setAmount(expense.getAmount());
            return expenseRepository.save(existingExpense);
        } else {
            return null;
        }
    }

    public void deleteExpense(int expenseId) {
        expenseRepository.deleteById(expenseId);
    }

    public List<Expense> findByCategory(int categoryId) {
        return expenseRepository.findByCategory(categoryId);
    }

    public List<Expense> findByUser(int userId) {
        return expenseRepository.findbyUser(userId);
    }
}
