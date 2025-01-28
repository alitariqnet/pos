package dev.ali.pos.service;

import dev.ali.pos.entity.Cashier;
import dev.ali.pos.entity.Item;
import dev.ali.pos.entity.Order;
import dev.ali.pos.entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private static final Logger log = LoggerFactory.getLogger(InvoiceService.class);

    public void printReceipt(Order order, Transaction transaction, List<Item> items){
        log.info("Printing Invoice...");
        System.out.println("+---------------------Invoice Service-------------------+");
        System.out.printf("%-8s%-15s%-12s%-6s%-7s%-7s%n", "| ID.", "Name", "UnitPrice", "Qty", "Disc", "Total   |");
        System.out.println("|              ---------------------------              |");

        items.forEach(item -> {
            System.out.printf("| %-6s%-15s%-12.2f%-6d%-7d%-7.2f |%n",
                    item.getSerialNo(),
                    item.getName(),
                    item.getUnitPrice(),
                    item.getQuantity(),
                    item.getDiscount(),
                    item.isPromotion() ? item.getDiscountedPrice() * item.getQuantity() : item.getUnitPrice() * item.getQuantity()
            );
        });
        System.out.println("|              ---------------------------              |");
        System.out.printf("|%30sSubtotal: %14.2f |%n", "", transaction.getSubTotal());
        System.out.printf("|%30sService fee: %11.2f |%n", "", transaction.getServiceFee());
        System.out.printf("|%30sNet payable: %11.2f |%n", "", transaction.getNetPayable());
        System.out.printf("|%30sAmount received: %7.2f |%n", "", transaction.getReceivedAmount());
        System.out.printf("|%30sChange due: %12.2f |%n", "", transaction.getChangeDueAmount());
        System.out.println("+-------------------------------------------------------+");

    }

}
