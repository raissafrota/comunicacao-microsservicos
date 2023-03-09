package br.com.raissafrota.comunicationmicrosservices.productapi.controller;

import br.com.raissafrota.comunicationmicrosservices.productapi.dto.request.SupplierRequest;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.SupplierResponse;
import br.com.raissafrota.comunicationmicrosservices.productapi.service.SupplierService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @GetMapping
    public List<SupplierResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("{id}")
    public SupplierResponse findById(@PathVariable Integer id) {
        return service.findByIdResponse(id);
    }

    @GetMapping("name/{name}")
    public List<SupplierResponse> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    @PostMapping
    public SupplierResponse save(@RequestBody SupplierRequest request){
        return service.save(request);
    }
}
