package ma.enset.cassandraapp.services;

import ma.enset.cassandraapp.entites.Product;
import ma.enset.cassandraapp.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public  void  addProduct(String name,float prix,int qte){
        Product product=new Product();
        product.setId(UUID.randomUUID());
        product.setName(name);
        product.setPrix(prix);
        product.setQte(qte);
        productRepository.insert(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Product getProduct(String name){
        return  productRepository.findByName(name);
    }
    public Product updateProduct(float prix,int qte,String name){
        Product product=productRepository.findByName(name);
        product.setPrix(prix);
        product.setQte(qte);
        return productRepository.save(product);

    }
    public void deleteProduct(String name){
          productRepository.deleteProductByName(name);
    }
}

