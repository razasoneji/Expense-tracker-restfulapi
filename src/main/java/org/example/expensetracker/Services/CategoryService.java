package org.example.expensetracker.Services;

import org.example.expensetracker.Entities.Category;
import org.example.expensetracker.Entities.Expense;
import org.example.expensetracker.Entities.User;
import org.example.expensetracker.dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public Category saveCategory(Category category) {

        return categoryRepository.save(category);
    }


    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }


    public Optional<Category> findByIdCategory(int userId) {
        return categoryRepository.findById(userId);
    }

    public Category updateCategory(Category category, int userId) {
        Category existingCategory = categoryRepository.findById(userId).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            existingCategory.setDescription(category.getDescription());
            return categoryRepository.save(existingCategory);
        } else {
            return null;
        }
    }

    public void deleteByIdCategory(int userId) {
        categoryRepository.deleteById(userId);
    }
//locho
    //locha
    //locha
//    public List<Expense> allexpensesbycategory(int categoryId) {
//        return categoryRepository.expensesbycategory(categoryId);
//    }
}
