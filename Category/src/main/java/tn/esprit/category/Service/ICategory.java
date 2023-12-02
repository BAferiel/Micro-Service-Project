package tn.esprit.category.Service;

import tn.esprit.category.Entity.Category;

import java.util.List;

public interface ICategory {
    Category createCategory(Category category);
    Category getCategoryById(Long id_category);
    List<Category> getAllCategories();
    Category updateCategory(Long id_category, Category updatedCategory);
    void deleteCategory(Long id_category);
}
