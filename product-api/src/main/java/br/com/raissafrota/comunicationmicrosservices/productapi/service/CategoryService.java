package br.com.raissafrota.comunicationmicrosservices.productapi.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import br.com.raissafrota.comunicationmicrosservices.productapi.dto.request.CategoryRequest;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.CategoryResponse;
import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Category;
import br.com.raissafrota.comunicationmicrosservices.productapi.exception.ValidationException;
import br.com.raissafrota.comunicationmicrosservices.productapi.repository.CategoryRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryResponse save(CategoryRequest categoryRequest){
        validateCategoryNameInformed(categoryRequest);
        var category = repository.save(Category.of(categoryRequest));
        return  CategoryResponse.of(category);
    }

    private void validateCategoryNameInformed(CategoryRequest request) {
        if (isEmpty(request.getDescription())) {
            throw new ValidationException("The category description was not informed.");
        }
    }

    public Category findById(Integer id){
        validateInformedId(id);
        return repository.findById(id).orElseThrow(() -> new ValidationException("There's no supplier for the given ID."));
    }

    public CategoryResponse findByIdResponse(Integer id) {
        return CategoryResponse.of(findById(id));
    }

    public List<CategoryResponse> findAll() {
        return repository
                .findAll()
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    public List<CategoryResponse> findByDescription(String description) {
        if (isEmpty(description)) {
            throw new ValidationException("The category description must be informed.");
        }
        return repository
                .findByDescriptionIgnoreCaseContaining(description)
                .stream()
                .map(CategoryResponse::of)
                .collect(Collectors.toList());
    }

    private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The category ID must be informed.");
        }
    }
}
