package org.example.expensetracker.Controllers;

import org.example.expensetracker.Entities.Category;
import org.example.expensetracker.Entities.Expense;
import org.example.expensetracker.Services.CategoryService;
import org.example.expensetracker.dao.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    /// create operation on category

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    // read operation on category

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.findAllCategory();
    }

    @GetMapping("/{categoryId}")
    public Optional<Category> getByIdCategory(@PathVariable int categoryId){
        return categoryService.findByIdCategory(categoryId);
    }


    @PutMapping("/{categoryId}")
    public Category updateCategory(@RequestBody Category category, @PathVariable int categoryId){
        return categoryService.updateCategory(category,categoryId);
    }

    //delete operations

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable int categoryId){
        categoryService.deleteByIdCategory(categoryId);
    }




}


