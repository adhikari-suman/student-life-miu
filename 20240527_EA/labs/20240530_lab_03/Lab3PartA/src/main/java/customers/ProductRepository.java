package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void save(Product product) {
        // Save supplier
        Map<String, Object> namedParameters1 = new HashMap<>();

        namedParameters1.put("id", product.getSupplier().getId());
        namedParameters1.put("name", product.getSupplier().getName());
        namedParameters1.put("phone", product.getSupplier().getPhone());

        jdbcTemplate.update("INSERT INTO supplier VALUES(:id, :name, :phone)", namedParameters1);

        // save product
        Map<String, Object> namedParameters = new HashMap<>();

        namedParameters.put("productNumber", product.getProductNumber());
        namedParameters.put("supplierId", product.getSupplier().getId());
        namedParameters.put("name", product.getName());
        namedParameters.put("price", product.getPrice());

        jdbcTemplate.update("INSERT INTO product VALUES(:productNumber, :name, :price, :supplierId)", namedParameters);
    }

    public Product findByProductNumber(int productNumber) {
        Map<String, Object> namedParameters = new HashMap<>();

        namedParameters.put("productNumber", productNumber);

        Product p = jdbcTemplate.queryForObject("SELECT * FROM product WHERE product_number = :productNumber",
                namedParameters,
                (rs, rowNum) -> new Product(
                        rs.getInt("product_number"),
                        rs.getString("name"),
                        rs.getDouble("price")

                )
        );

        return p;

    }

    public List<Product> getAllProducts() {
        List<Product> products = jdbcTemplate.query("SELECT * FROM product",
                (rs, rowNum) -> new Product(
                        rs.getInt("product_number"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
        );

        return  products;
    }

    public Product findByProductName(String productName) {
        Map<String, Object> namedParameters = new HashMap<>();

        namedParameters.put("name", productName);

        Product p = jdbcTemplate.queryForObject("SELECT * FROM product WHERE name = :name",
                namedParameters,
                (rs, rowNum) -> new Product(
                        rs.getInt("product_number"),
                        rs.getString("name"),
                        rs.getDouble("price")
                )
        );

        return p;
    }

    public void removeProduct(int productNumber) {
        Map<String, Object> namedParameters = new HashMap<>();

        namedParameters.put("productNumber", productNumber);

        jdbcTemplate.update("DELETE FROM product WHERE product_number = :productNumber", namedParameters);
    }
}
