package br.com.escriba.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.escriba.model.Category;
import br.com.escriba.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/listAll")
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/newCategory")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryRepository.save(category);
        return ResponseEntity.created(URI.create("/api/categories/" + savedCategory.getId())).body(savedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category) {
        if (!categoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        category.setId(id);
        Category updatedCategory = categoryRepository.save(category);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        if (!categoryRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoryRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/most-common-letter/{letter}")
    public ResponseEntity<Category> getCategoryWithMostOccurrences(@PathVariable char letter) {
        List<Category> allCategories = categoryRepository.findAll();
        Category categoryWithMostOccurrences = null;
        int maxOccurrences = 0;

        for (Category category : allCategories) {
            int count = countOccurrences(category.getName(), letter);
            if (count > maxOccurrences) {
                maxOccurrences = count;
                categoryWithMostOccurrences = category;
            }
        }
        if (categoryWithMostOccurrences != null) {
            return ResponseEntity.ok().body(categoryWithMostOccurrences);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    private int countOccurrences(String str, char letter) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(letter)) {
                count++;
            }
        }
        return count;
    }
}