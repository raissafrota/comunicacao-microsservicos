package br.com.raissafrota.comunicationmicrosservices.productapi.dto.request;

import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.CategoryResponse;
import br.com.raissafrota.comunicationmicrosservices.productapi.dto.response.SupplierResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class ProductRequest {

    private String name;
    private Integer supplierId;
    private Integer categoryId;
    @JsonProperty("quantity_available")
    private Integer quantityAvailable;
}
