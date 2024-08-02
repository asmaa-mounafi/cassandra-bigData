package ma.enset.cassandraapp.repository;

import ma.enset.cassandraapp.entites.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {

     Product findByName(String name);
     Product deleteProductByName(String name);
}
