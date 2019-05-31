/**
 * <h1>ItemController.java</h1>
 * <p>
 * Item controller for Springboot Framework
 * </p>
 *
 * @author Mahdi Yusuf
 * @version 13.0
 * @since 2019/31/05
 */
package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ItemController {

    /**
     * Get all items request
     *
     * @return the array list of items
     */
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ArrayList<Item> itemList() {
        return DatabaseItem.getItemDatabase();
    }

    /**
     * Get item by id request
     *
     * @param id_item the item id
     * @return the item from id
     */
    @RequestMapping(value = "/items/{id_item}", method = RequestMethod.GET)
    public Item getItemFromID(@PathVariable int id_item) {
        Item item = DatabaseItem.getItemFromID(id_item);
        return item;
    }
}