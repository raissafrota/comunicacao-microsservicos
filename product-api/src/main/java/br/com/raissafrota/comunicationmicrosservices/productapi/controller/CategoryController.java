package br.com.raissafrota.comunicationmicrosservices.productapi.controller;

import br.com.raissafrota.comunicationmicrosservices.productapi.dto.request.CategoryRequestDto;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.CategoryResponseDto;
import br.com.raissafrota.comunicationmicrosservices.productapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping
    public CategoryResponseDto save(@RequestBody CategoryRequestDto categoryRequestDto){
        return service.save(categoryRequestDto);
    }
}
