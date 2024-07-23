package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private EmailSender emailSender;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, EmailSender emailSender) {
        this.productRepository = productRepository;
        this.emailSender = emailSender;
    }

    @Override
    public void addProduct(String email, String name, double price) {
        Product product = new Product(name, price);
        productRepository.save(product);
        emailSender.sendEmail(email, "Product "+ product.getName()+ " has been added.");
    }
}
