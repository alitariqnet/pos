package dev.ali.pos.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@Entity
@Table(name = "transactions")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "subTotal")
    private double subTotal;
    @Column(name = "net_payable")
    private double netPayable;
    @Column(name = "service_fee")
    private double serviceFee;
    @Column(name = "received_amount")
    private double receivedAmount;
    @Column(name = "change_due")
    private double changeDueAmount;
    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getNetPayable() {
        return netPayable;
    }

    public void setNetPayable(double netPayable) {
        this.netPayable = netPayable;
    }

    public double getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }

    public double getReceivedAmount() {
        return receivedAmount;
    }

    public void setReceivedAmount(double receivedAmount) {
        this.receivedAmount = receivedAmount;
    }

    public double getChangeDueAmount() {
        return changeDueAmount;
    }

    public void setChangeDueAmount(double changeDueAmount) {
        this.changeDueAmount = changeDueAmount;
    }
}
