package dev.ali.pos.service;

import dev.ali.pos.entity.Item;
import dev.ali.pos.entity.Order;
import dev.ali.pos.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private InvoiceService invoiceService;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }
    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }
    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }
    public List<Order> findOrdersByTransactionId(Long id){
        return orderRepository.findByTransactionId(id);
    }
    public List<Order> findOrdersByCashierId(Long id){
        return orderRepository.findByCashierId(id);
    }
    public void pickItemsAndInitOrder(){

    }
    public void initOrder(List<Item> items){
//        invoiceService.printReceipt();
    }
}
