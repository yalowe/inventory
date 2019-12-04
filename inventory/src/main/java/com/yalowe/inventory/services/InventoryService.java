package com.yalowe.inventory.services;
import com.yalowe.inventory.beans.Item;
import jdk.nashorn.internal.parser.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryService extends JpaRepository<Item, Integer> {

    //public Item findByCode(int cod);

    //List<Token> findByToken(int code);


}
