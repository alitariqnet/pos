package dev.ali.pos.service;

import dev.ali.pos.entity.Cashier;
import dev.ali.pos.entity.Order;
import dev.ali.pos.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    private static final Logger log = LoggerFactory.getLogger(InvoiceService.class);

    private static void printReceipt(Order order, Transaction transaction, Cashier cashier){
        log.info("Printing Invoice...");
        System.out.println("""
                +----------------Print Service---------------+
                |                                            |
                |                                            |
                |                                            |
                |                                            |
                |                                            |
                |                                            |
                |                                            |
                |                                            |
                |                                            |
                +--------------------------------------------+
                """);
    }

}
