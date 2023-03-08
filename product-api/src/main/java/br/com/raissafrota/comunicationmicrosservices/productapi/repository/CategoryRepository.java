package br.com.raissafrota.comunicationmicrosservices.productapi.repository;

import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
