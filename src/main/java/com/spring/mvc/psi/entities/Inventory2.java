package com.spring.mvc.psi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "INVENTORY2")
public class Inventory2 {
    @Id
    private Integer id;
    
    @Column
    private String name;
    
    @Column(name = "QTY")
    private Integer qty;
    
    @Column(name = "COST")
    private Integer cost;
    
    @Column(name = "PRICE1")
    private Integer price1;
    
    @Column(name = "PRICE2")
    private Integer PRICE2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getPrice1() {
        return price1;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public Integer getPRICE2() {
        return PRICE2;
    }

    public void setPRICE2(Integer PRICE2) {
        this.PRICE2 = PRICE2;
    }

    @Override
    public String toString() {
        return "Inventory2{" + "id=" + id + ", name=" + name + ", qty=" + qty + ", cost=" + cost + ", price1=" + price1 + ", PRICE2=" + PRICE2 + '}';
    }


    
    
}