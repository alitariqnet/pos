package dev.ali.pos.service;

import dev.ali.pos.entity.Item;
import dev.ali.pos.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    private static final Logger log = LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private ItemRepository itemRepository;

    public Item create(Item item){
        return itemRepository.save(item);
    }
    public Item update(Item item){
        return itemRepository.save(item);
    }
    public void delete(Item item){
        itemRepository.delete(item);
    }

    public void createItem(String name, double unitPrice, int discount, boolean promotion, int quantity){

        Item item = new Item();
        item.setName(name);
        item.setUnitPrice(unitPrice);
        item.setDiscount(discount);
        item.setQuantity(quantity);
        if(promotion){
            item.setPromotion(promotion);
            double discountedPrice = discount * unitPrice/100;
            item.setDiscountedPrice(discountedPrice);
        }
        if(quantity > 1){
            if (promotion){
                item.setTotalPrice(quantity * item.getDiscountedPrice());
            }else{
                item.setTotalPrice(quantity * item.getUnitPrice());
            }
        }
        Item item1 = this.create(item);
    }

}
