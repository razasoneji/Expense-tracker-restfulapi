package org.example.expensetracker.dao;

import org.example.expensetracker.Entities.Category;
import org.example.expensetracker.Entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
