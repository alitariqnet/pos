package dev.ali.pos.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;
// Order is the representation of a cart
@Entity
@Table(name = "orders")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cashier_id")
    private Long cashierId;
    @Column(name = "transaction_id")
    private Long transactionId;
    @OneToMany(mappedBy = "orders")
    private List<Item> items;
    @Column(name = "total_amount")
    private double totalAmount;
    // Either the order is successful or not
    // e.g. If a customer quits at cart before checkout
    // for unplaced order we can remind customer about incomplete order
    @Column(name = "checkout")
    private boolean checkout;
    @Column(name = "created_on")
    @CreatedDate
    private LocalDateTime createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return cashierId;
    }

    public void setCustomerId(Long customerId) {
        this.cashierId = customerId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean checkout() {
        return checkout;
    }

    public void setPlaced(boolean placed) {
        checkout = placed;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
