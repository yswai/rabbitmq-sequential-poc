package org.springframework.amqp.tutorials;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

  Optional<Product> findByName(String name);

}
