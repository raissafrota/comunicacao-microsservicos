package br.com.raissafrota.comunicationmicrosservices.productapi.controller;

import br.com.raissafrota.comunicationmicrosservices.productapi.dto.request.CategoryRequest;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.request.ProductRequest;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.CategoryResponse;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.ProductResponse;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.SuccessResponse;
import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Category;
import br.com.raissafrota.comunicationmicrosservices.productapi.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public List<CategoryResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public CategoryResponse findById(@PathVariable Integer id){
        return service.findByIdResponse(id);
    }

    @GetMapping("description/{description}")
    public List<CategoryResponse> findByDescription(@PathVariable String description) {
        return service.findByDescription(description);
    }

    @PostMapping
    public CategoryResponse save(@RequestBody CategoryRequest categoryRequest){
        return service.save(categoryRequest);
    }

    @PutMapping("{id}")
    public CategoryResponse update(@RequestBody CategoryRequest request, @PathVariable Integer id ){
        return service.update(request, id);
    }

    @DeleteMapping("{id}")
    SuccessResponse delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
