package com.alibaba.controller;

import com.alibaba.dto.ItemDto;
import com.alibaba.entity.Brand;
import com.alibaba.entity.Category;
import com.alibaba.entity.Item;
import com.alibaba.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/addItem")
    public ResponseEntity<Item> addItem(@RequestBody ItemDto itemDto){

        Item newItem = itemService.addItem(itemDto);
        return new ResponseEntity<>(newItem, HttpStatus.CREATED);
    }

    @GetMapping("/getAllItems")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> ItemList = itemService.getAllItem();
        return new ResponseEntity<>(ItemList,HttpStatus.OK);
    }


    @GetMapping("/getItemById/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") Long id){

        Item item= itemService.getItemById(id);

        return new ResponseEntity<>(item,HttpStatus.OK);
    }

    @PutMapping("/updateItem/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") Long id, @RequestBody ItemDto itemDto){
        Item item = itemService.updateItem(itemDto, id);
        return new ResponseEntity<>(item,HttpStatus.OK);
    }


    @DeleteMapping("/deleteById/{itemId}")
    public ResponseEntity<String> deleteItemById(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
        return new ResponseEntity<>("Item was successfully deleted.", HttpStatus.OK);
    }

}
