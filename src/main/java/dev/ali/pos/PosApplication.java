package dev.ali.pos;

import dev.ali.pos.entity.Manager;
import dev.ali.pos.entity.Product;
import dev.ali.pos.entity.Supplier;
import dev.ali.pos.entity.User;
import dev.ali.pos.repository.ProductRepository;
import dev.ali.pos.repository.SupplierRepository;
import dev.ali.pos.service.ManagerService;
import dev.ali.pos.service.SalesService;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PosApplication {

    private static final Logger log = LoggerFactory.getLogger(PosApplication.class);

    @Autowired
    private SalesService salesService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ManagerService managerService;

    static {
        log.info("POS application initialization...");
    }

    public static void main(String[] args) {
        log.info("Starting POS application...");
        SpringApplication.run(PosApplication.class, args);
        // TODO: Write a command line runner to populate database with initial values such as products
    }

    @PostConstruct
    public void simulate() {
        log.info("Inside PostConstruct simulate");
        log.info("Starting simulate sales service...");
        salesService.simulateSales();
    }

//    @Bean
//    public CommandLineRunner runner(ProductRepository productRepository) {
//        return args -> {
//			User user = new User("ROLE_USER", "alibaba_user","pass",true);
//			Manager manager = managerService.create("Ali", "Tariq","alibabapk@aol.com","1118174","Shalamar link road","m","alibaba","pass");
//			log.info("New manager created ->", manager);

//			Supplier supplier = new Supplier("Hakim and sons.", "Shah Alam market, Lahore", "0422348593");
//            Supplier supplier = supplierRepository.findByName("Hakim and sons.");
//
//            List<Product> productList = List.of(
//                    new Product("Bonus", null, "washing", "Washing powder", "Unilever", supplier, "Available", 100),
//                    new Product("Surf Excel", null, "washing", "Washing powder", "Unilever", supplier, "Available", 150),
//                    new Product("Bright", null, "washing", "Washing powder", "Unilever", supplier, "Available", 200),
//                    new Product("creme 21", null, "cosmetics", "Skin care", "Henkel AG & Co. KGaA", supplier, "Available", 100),
//                    new Product("Nivea", null, "cosmetics", "Cream", "Beiersdorf AG", supplier, "Available", 150),
//                    new Product("Ponds", null, "cosmetics", "Beauty lotion", "Unilever PLC", supplier, "Available", 200),
//                    new Product("Pepsi", "1 litre", "beverage", "Cold drink", "PepsiCo", supplier, "Available", 100),
//                    new Product("Teem", "1 litre", "beverage", "Cold drink", "PepsiCo", supplier, "Available", 100),
//                    new Product("Mirinda", "1 litre", "beverage", "Cold drink", "PepsiCo", supplier, "Available", 100),
//                    new Product("Bread", "Large 1000gm", "bakery", "Breakfast item", "Rahat Bakers", supplier, "Available", 100),
//                    new Product("Rusk", "Medium 400gm", "bakery", "Breakfast item", "Rahat Bakers", supplier, "Available", 120),
//                    new Product("Bakarkhani", "Small 250gm", "bakery", "Breakfast item", "Rahat Bakers", supplier, "Available", 130));
//            productRepository.saveAll(productList);
//        };
//    }

}
