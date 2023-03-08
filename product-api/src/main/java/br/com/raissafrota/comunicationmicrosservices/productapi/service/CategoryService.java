package br.com.raissafrota.comunicationmicrosservices.productapi.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import br.com.raissafrota.comunicationmicrosservices.productapi.dto.request.CategoryRequestDto;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.CategoryResponseDto;
import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Category;
import br.com.raissafrota.comunicationmicrosservices.productapi.exception.ValidationException;
import br.com.raissafrota.comunicationmicrosservices.productapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryResponseDto save(CategoryRequestDto categoryRequestDto){
        validateCategoryNameInformed(categoryRequestDto);
        var category = categoryRepository.save(Category.of(categoryRequestDto));
        return  CategoryResponseDto.of(category);
    }

    private void validateCategoryNameInformed(CategoryRequestDto request) {
        if (isEmpty(request.getDescription())) {
            throw new ValidationException("The category description was not informed.");
        }
    }
}
