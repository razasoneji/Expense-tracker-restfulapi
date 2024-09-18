package org.example.expensetracker.dao;

import org.example.expensetracker.Entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer> {
    @Query(value = "SELECT * FROM expense WHERE category_id = ?1", nativeQuery = true)
    List<Expense> findByCategory(int categoryId);

    @Query(value = "SELECT * FROM expense WHERE user_id = ?1", nativeQuery = true)
    List<Expense> findbyUser(int userId);
}
