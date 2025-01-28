package dev.ali.pos.service;

import dev.ali.pos.entity.*;
import dev.ali.pos.mapper.ProductMapper;
import dev.ali.pos.repository.ItemRepository;
import dev.ali.pos.repository.OrderRepository;
import dev.ali.pos.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
@Transactional
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
    private InvoiceService invoiceService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ItemRepository itemRepository;


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

        List<Long> ids = List.of(16L,17L,18L);
        List<Item> items = this.selectItems(ids);
        double changeDue = this.createOrder(500,items);
        log.info("Change due -> "+changeDue);

    }

    public List<Item> selectItems(List<Long> ids){
        // init order
        Integer itemCount = 1;
        List<Item> items = new LinkedList<>();

        for(Long id: ids){
            Optional<Product> product = productService.findById(id);
            Item item = ProductMapper.productToItem(product.get());
            item.setId(itemCount.longValue());
            // Assuming regular product with no promotion
            item.setPromotion(false);
            // Assuming quantity as 1 for each product
            item.setQuantity(1);
            log.info("Selected item"+itemCount+" price -> "+ item.getUnitPrice());
            items.add(item);
            itemCount++;
        }
       return items;
    }

    public double createOrder(double receivedAmount, List<Item> items){
        log.info("Entering inside createOrder method in SalesService class...");
        Long cashierId = 11L;
        // Create a new order
        Order order = new Order();
        order.setCashierId(cashierId);

        // Create a new transaction
        Transaction transaction = new Transaction();
        transaction.setCashierId(cashierId);

        // Get total number of items
        int totalNumberOfItems = items.stream().mapToInt(Item::getQuantity).sum();
        transaction.setQuantity(totalNumberOfItems);
        log.info("Total number of items -> "+totalNumberOfItems);
        // Rs. 1 POS service fee
        transaction.setServiceFee(1L);

        // Adding total of each item to get sub-total
        double subTotal = this.calculateTotal(items);
        double netPayable = subTotal+transaction.getServiceFee();
        log.info("Sub-total -> "+subTotal);
        log.info("Netpayable -> "+netPayable);
        order.setTotalAmount(netPayable);
        transaction.setCashierId(cashierId);
        transaction.setNetPayable(netPayable);
        transaction.setReceivedAmount(receivedAmount);
        double changeDue = receivedAmount - netPayable;
        transaction.setChangeDueAmount(changeDue);
        log.info("Received amount -> "+receivedAmount);
        log.info("Change due -> "+changeDue);
        order.setTransaction(transaction);
        this.checkout(order,transaction,items);
        this.printInvoice(order, transaction, items);
        return changeDue;
    }
    void checkout(Order order, Transaction transaction, List<Item> items){
        log.info("Entering checkout...");
        order.setCheckout(true);
        Order order1 = orderRepository.save(order);
        items.forEach(item -> item.setOrder(order1));

        log.info("Order1 id -> "+order1.getId());
        transactionRepository.save(transaction);
        log.info("Leaving checkout...");
    }

    public double calculateTotal(List<Item> items) {
        double total = items.stream()
                .mapToDouble(item -> {
                    double itemTotalPrice = item.isPromotion() ? item.getDiscountedPrice() * item.getQuantity() : item.getUnitPrice() * item.getQuantity();
                    log.info("itemTotalPrice -> "+ itemTotalPrice);
                    return itemTotalPrice;
                })
                .sum();
        log.info("total -> "+ total);
        return total;
    }

    public void printInvoice(Order order, Transaction transaction, List<Item> items){
        invoiceService.printReceipt(order, transaction, items);
    }
}
