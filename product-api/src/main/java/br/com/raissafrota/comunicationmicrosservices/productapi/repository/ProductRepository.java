package br.com.raissafrota.comunicationmicrosservices.productapi.repository;

import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
