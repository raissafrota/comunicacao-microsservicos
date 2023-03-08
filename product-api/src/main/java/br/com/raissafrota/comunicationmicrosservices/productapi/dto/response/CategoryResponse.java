package br.com.raissafrota.comunicationmicrosservices.productapi.dto.response;

import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Category;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CategoryResponse {

    private Integer id;
    private String description;

    public static CategoryResponse of(Category category) {
        var response = new CategoryResponse();
        BeanUtils.copyProperties(category,response);
        return response;
    }
}
