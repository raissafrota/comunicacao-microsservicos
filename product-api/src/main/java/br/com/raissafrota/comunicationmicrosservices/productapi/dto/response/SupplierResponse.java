package br.com.raissafrota.comunicationmicrosservices.productapi.dto.response;

import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Supplier;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class SupplierResponse {

    private int id;
    private String name;

    public static SupplierResponse of(Supplier supplier){
        var response = new SupplierResponse();
        BeanUtils.copyProperties(supplier,response);
        return response;
    }
}
