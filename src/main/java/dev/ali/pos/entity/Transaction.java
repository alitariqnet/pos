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

    @OneToOne
    private Order order;

    @Column(name = "cashier_id")
    private Long cashierId;

    @Column(name = "quantity")
    private int quantity;

    // Total amount before including any taxes or service fees and before giving any discounts
    @Column(name = "subTotal")
    private double subTotal;

    // Total payable amount after including any taxes or service fees and after giving any discounts
    @Column(name = "net_payable")
    private double netPayable;

    @Column(name = "service_fee")
    private double serviceFee;

    @Column(name = "received_amount")
    private double receivedAmount;

    // change due = received amount - net payable
    @Column(name = "change_due")
    private double changeDueAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Long getCashierId() {
        return cashierId;
    }

    public void setCashierId(Long cashierId) {
        this.cashierId = cashierId;
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
