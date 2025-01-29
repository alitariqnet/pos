package dev.ali.pos.mapper;

import dev.ali.pos.entity.Item;
import dev.ali.pos.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static Item productToItem(Product product, boolean promotion, int discount){

        Item item = new Item();
        item.setName(product.getName());
        item.setProductId(product.getId());
        // If true then item.discount should contain a value from 1 to 99 or 100 if free :)
        item.setPromotion(promotion);
        // In percentage
        item.setDiscount(discount);
        item.setUnitPrice(product.getPrice());
        if(item.isPromotion()){
            item.setDiscountedPrice(item.getUnitPrice() - (item.getDiscount() * item.getUnitPrice()/100));
        }

        return item;
    }
}
