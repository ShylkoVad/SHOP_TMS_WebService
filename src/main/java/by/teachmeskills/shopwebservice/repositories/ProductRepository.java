package by.teachmeskills.shopwebservice.repositories;

import by.teachmeskills.shopwebservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {
    List<Product> findAllByCategoryId(int categoryId);

    @Query(value = "select * from shop.products where name  = :parameter", nativeQuery = true)
    List<Product> findAllBySearchParameter(@Param("parameter") String parameter);
}
