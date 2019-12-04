package com.yalowe.inventory.beans;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Items")/*,
        uniqueConstraints = @UniqueConstraint(columnNames={"CODE"})*/

public class Item {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AMOUNT")
    private int amount;

    @Column(name = "CODE",unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int inventoryCode;

    public Item(String name, int amount, int code) {
        this.name = name;
        this.amount = amount;
        this.inventoryCode = code;
    }

    public static int size() {

        return Item.size();
    }
}
