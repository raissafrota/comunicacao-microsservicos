package br.com.raissafrota.comunicationmicrosservices.productapi.repository;

import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
