package com.example.FakeCommerceApp.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_products")
public class OrderProduct extends BaseEntity {

    @ManyToOne(fetch =  FetchType.LAZY)
    @JoinColumn(nullable = false, name = "order_id")
    public Order order;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false, name =  "product_id")
    public Product product;

    @Column(nullable = false)
    private Integer quantity;

}
