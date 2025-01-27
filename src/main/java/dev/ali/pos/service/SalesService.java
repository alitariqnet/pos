package dev.ali.pos.service;

import dev.ali.pos.entity.*;
import dev.ali.pos.mapper.ProductMapper;
import dev.ali.pos.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;

@Service
public class SalesService {
    private static final Logger log = LoggerFactory.getLogger(SalesService.class);
    @Autowired
    private UserService userService;

    @Autowired
    private CashierService cashierService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;

    public SalesService() {
    }

    public SalesService(UserService userService) {
        this.userService = userService;
    }

    public List<Order> getSalesByCashier(Long id, LocalDateTime fromDate, LocalDateTime toDate){
        // TODO: call getTransactionsByCashier id and then calculate sales per cashier for certain time period
        return null;
    }
    public List<Transaction> getTransactionsByCashier(Long id){
        // TODO: get orders by cashier for certain time period from TransactionRepository by cashier id
        return null;
    }

    public void simulateSales() {

//        Cashier cashier = new Cashier();
//        cashier.setFirstName("Ali");
//        cashier.setLastName("Tariq");
//        cashier.setGender("m");
//        cashier.setRole("ROLE_USER");
//        cashier.setUsername("alibaba");
        // Bcrypt password encryption is left because it is not required for this demo system
        // Passwords should be saved in encrypted form in the database
//        cashier.setPassword("pass");
//        cashier.setAddress("Shalamar link road");
//        cashier.setPhone("1234567");
//        userService.create(cashier);
//        if (cashier == null) {
//            log.info("Username already exists. Please choose another username.");
//        } else {
//            log.info("New cashier created ->", cashier);
//        }
//        Manager manager = new Manager();
//        manager.setFirstName("Ali");
//        manager.setLastName("Tariq");
//        manager.setGender("m");
//        manager.setRole("ROLE_USER");
//        manager.setUsername("alibaba");
        // Bcrypt password encryption is left because it is not required for this demo system
        // Passwords should be saved in encrypted form in the database
//        manager.setPassword("pass");
//        manager.setAddress("Shalamar link road");
//        manager.setPhone("1234567");
//        userService.create(manager);
//        if (manager == null) {
//            log.info("Username already exists. Please choose another username.");
//        } else {
//            log.info("New manager created ->", manager);
//        }
//        Admin admin = new Admin();
//        admin.setFirstName("Ali");
//        admin.setLastName("Tariq");
//        admin.setRole("ROLE_ADMIN");
//        admin.setUsername("alibaba");
        // Bcrypt password encryption is left because it is not required for this demo system
        // Passwords should be saved in encrypted form in the database
//        admin.setPassword("pass");
//        admin.setPhone("1234567");
//        userService.create(admin);
//        if (admin == null) {
//            log.info("Username already exists. Please choose another username.");
//        } else {
//            log.info("New admin created ->", admin);
//        }
    }

    public List<Item> selectItems(List<Long> ids){
        // init order
        int itemCount = 1;
        List<Item> items = new LinkedList<>();

        for(Long id: ids){
            Optional<Product> product = productService.findById(id);
            Item item = ProductMapper.productToItem(product.get());
            log.info("First selected item"+itemCount+" -> ", item);
            items.add(item);
        }
       return items;
    }

    void createOrder(Long cashierId, double totalAmount){
        Order order = new Order();
        order.setCashierId(cashierId);
        order.setTotalAmount(totalAmount);
    }
    void checkout(Order order){
        assertNotNull(orderRepository.save(order));
    }

    public void calculateTotal(List<Item> items) {
//        items.stream().reduce()
    }
}
