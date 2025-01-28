package dev.ali.pos.mapper;

import dev.ali.pos.entity.Item;
import dev.ali.pos.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static Item productToItem(Product product){

        Item item = new Item();
        item.setName(product.getName());
        item.setProductId(product.getId());
        // If true then item.discount should contain a value from 1 to 99 or 100 if free :)
        item.setPromotion(true);
        // In percentage
        item.setDiscount(5);
        item.setUnitPrice(product.getPrice());
        if(item.isPromotion()){
            item.setDiscountedPrice(item.getUnitPrice() - (item.getDiscount() * item.getUnitPrice()/100));
        }

        return item;
    }
}
