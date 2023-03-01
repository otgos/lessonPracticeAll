package com.alibaba.service;

import com.alibaba.dto.ItemDto;
import com.alibaba.entity.Brand;
import com.alibaba.entity.Category;
import com.alibaba.entity.Item;
import com.alibaba.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    public Item addItem(ItemDto itemDto){

        Item newItem = new Item();

        Brand brand = brandService.getById(itemDto.getBrandId());
        Category category = categoryService.getCategoryById(itemDto.getCategoryId());

        newItem.setName(itemDto.getName());
        newItem.setColor(itemDto.getColor());
        newItem.setSize(itemDto.getSize());
        newItem.setPrice(itemDto.getPrice());
        newItem.setDescription(itemDto.getDescription());
        newItem.setBrand(brand);
        newItem.setCategory(category);


        return itemRepository.save(newItem);

    }

    public List<Item> getAllItem(){
        List<Item> items = itemRepository.findAll();
        return items;
    }

    public Item getItemById(Long id){

        return itemRepository.findById(id).orElseThrow();

    }


    public Item updateItem(ItemDto itemDto, Long id){

        Item foundItem = itemRepository.findById(id).orElseThrow();

        Brand brand = brandService.getById(itemDto.getBrandId());
        Category category = categoryService.getCategoryById(itemDto.getCategoryId());

        foundItem.setName(itemDto.getName());
        foundItem.setColor(itemDto.getColor());
        foundItem.setSize(itemDto.getSize());
        foundItem.setPrice(itemDto.getPrice());
        foundItem.setDescription(itemDto.getDescription());
        foundItem.setBrand(brand);
        foundItem.setCategory(category);


        return itemRepository.save(foundItem);

    }
    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }


}
