package br.com.raissafrota.comunicationmicrosservices.productapi.repository;

import br.com.raissafrota.comunicationmicrosservices.productapi.entity.Supplier;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    List<Supplier> findByNameIgnoreCaseContaining(String name);
}
