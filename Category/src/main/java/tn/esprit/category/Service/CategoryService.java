package tn.esprit.category.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.category.Entity.Category;
import tn.esprit.category.Repository.CategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService implements ICategory{
    private CategoryRepo categoryRepo;
    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category getCategoryById(Long id_category) {
        return categoryRepo.findById(id_category).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Long id_category, Category updatedCategory) {

        Optional<Category> optionalCategory=categoryRepo.findById(id_category);

        if(optionalCategory.isPresent()){
            Category existingCategory=optionalCategory.get();

            if (updatedCategory.getCategoryName() != null) {
                existingCategory.setCategoryName(updatedCategory.getCategoryName());
            }
            if (updatedCategory.getDescription() != null) {
                existingCategory.setDescription(updatedCategory.getDescription());
            }
            try{
                return categoryRepo.save(existingCategory);
            } catch (Exception e){
                throw new RuntimeException("Failed to update reclamation",e);
            }
        }
        else{
            return null;
        }
    }

    @Override
    public void deleteCategory(Long id_category) {
        Category existingCategory = getCategoryById(id_category);
        categoryRepo.delete(existingCategory);
    }
}
