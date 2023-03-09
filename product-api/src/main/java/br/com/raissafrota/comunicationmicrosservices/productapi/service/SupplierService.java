package br.com.raissafrota.comunicationmicrosservices.productapi.service;

import static org.springframework.util.ObjectUtils.isEmpty;

import br.com.raissafrota.comunicationmicrosservices.productapi.dto.request.SupplierRequest;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.SuccessResponse;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.SupplierResponse;
import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Supplier;
import br.com.raissafrota.comunicationmicrosservices.productapi.exception.ValidationException;
import br.com.raissafrota.comunicationmicrosservices.productapi.repository.SupplierRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor_ = { @Lazy})
public class SupplierService {

    @Autowired
    private SupplierRepository repository;
    @Lazy
    private ProductService productService;

    public List<SupplierResponse> findAll() {
        return repository
                .findAll()
                .stream()
                .map(SupplierResponse::of)
                .collect(Collectors.toList());
    }

    public SupplierResponse findByIdResponse(Integer id) {
        return SupplierResponse.of(findById(id));
    }

    public Supplier findById(Integer id) {
        validateInformedId(id);
        return repository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no supplier for the given ID."));
    }

    public List<SupplierResponse> findByName(String name) {
        if (isEmpty(name)) {
            throw new ValidationException("The supplier name must be informed.");
        }
        return repository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(SupplierResponse::of)
                .collect(Collectors.toList());
    }

    public SupplierResponse save(SupplierRequest supplierRequest){
        validateSupplierNameInformed(supplierRequest);
        var supplier = repository.save(Supplier.of(supplierRequest));
        return  SupplierResponse.of(supplier);
    }

    public SupplierResponse update(SupplierRequest request,
            Integer id) {
        validateSupplierNameInformed(request);
        validateInformedId(id);
        var supplier = Supplier.of(request);
        supplier.setId(id);
        repository.save(supplier);
        return SupplierResponse.of(supplier);
    }

    private void validateSupplierNameInformed(SupplierRequest request) {
        if (isEmpty(request.getName())) {
            throw new ValidationException("The supplier's name was not informed.");
        }
    }

    public SuccessResponse delete(Integer id) {
        validateInformedId(id);
        if (Boolean.TRUE.equals(productService.existsBySupplierId(id))) {
            throw new ValidationException("You cannot delete this supplier because it's already defined by a product.");
        }
        repository.deleteById(id);
        return SuccessResponse.create("The supplier was deleted.");
    }

    private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The supplier ID must be informed.");
        }
    }
}
