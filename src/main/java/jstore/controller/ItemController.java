package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;

@RestController
public class ItemController {

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ArrayList<Item> itemList() {
        return DatabaseItem.getItemDatabase();
    }

    @RequestMapping(value = "/items/{id_item}", method = RequestMethod.GET)
    public Item getItemFromID(@PathVariable int id_item) {
        Item item = DatabaseItem.getItemFromID(id_item);
        return item;
    }
}