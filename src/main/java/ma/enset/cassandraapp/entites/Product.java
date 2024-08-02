package ma.enset.cassandraapp.entites;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;
@Table("Products")
@NoArgsConstructor @AllArgsConstructor @Data
public class Product {
    @PrimaryKey
    private UUID id;
    private String name;
    private  float prix;
    private  int qte;

}
