package com.yalowe.inventory.controller;

import com.yalowe.inventory.beans.Item;
import com.yalowe.inventory.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer.Vanilla.std;
import static org.junit.Assert.assertEquals;

@RestController
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @RequestMapping(path = "/items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Item> getAllItems() {
        return inventoryService.findAll();
    }

    @RequestMapping(path = "/item", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Item getItemById(@RequestParam int id) {
        return this.inventoryService.findById(id).orElseThrow(null);
    }

    @RequestMapping(path = "/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Item setItem(@RequestParam String name, int amount, int code) {
        return this.inventoryService.save(new Item(name, amount, code));
    }

    //********************************************************************
    //public Item getItemByCode(@RequestParam int code) {
    @Autowired
    private EntityManager entityManager;

    @RequestMapping(path = "/itemcod", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Item findByCode(int code) {
        Item it = null;
        Query query = entityManager.createQuery("SELECT i FROM Item i WHERE item.code=:code");
        query.setParameter("CODE", code);
        try {
            it = (Item) query.getSingleResult();
        } catch (Exception e) {
            // Handle exception
        }

        return it;
    }


//    @ResponseBody
//    @RequestMapping(path ="/delete{inventoryCode}", method = RequestMethod.DELETE)
//    public String deleteItem(@PathVariable("inventoryCode") int inventoryCode) {
//        System.out.println("In deleteItem");
//
//    }
//
//    public String upDateItem(Item itm) {
//        for(int i=0; i < Item.size(); i++)
//        {
//            Item it = Item.get(i);
//            if(itm.getInventoryCode() == (std.getRegistrationNumber())) {
//                Item.set(i, std);//update the new record
//                return "Update successful";
//            }
//        }
//        return "Update un-successful";
}