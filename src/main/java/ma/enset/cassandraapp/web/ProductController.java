package ma.enset.cassandraapp.web;

import ma.enset.cassandraapp.entites.Product;
import ma.enset.cassandraapp.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<Product> getProducts(){
        return productService.getAllProduct();
    }
    @PostMapping
    public String saveProduct(@RequestParam String name,@RequestParam float prix,@RequestParam int qte){
        productService.addProduct(name,prix,qte);
        return  "Product Saved";
    }
    @GetMapping("/{name}")
    public Product getProduct(@RequestParam String name){
       return productService.getProduct(name);
    }
@PutMapping("/update/{name}")
  public Product updateProduct(@RequestParam float prix,@RequestParam int qte,@PathVariable String name){
        return productService.updateProduct(prix,qte,name);
  }
    @DeleteMapping("/{name}")
    public String deleteProduct(@PathVariable String name){
         productService.deleteProduct(name);
         return  "Product deleted";
    }


}
