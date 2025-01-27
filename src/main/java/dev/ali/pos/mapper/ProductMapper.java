package dev.ali.pos.mapper;

import dev.ali.pos.entity.Item;
import dev.ali.pos.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static Item productToItem(Product product){

        Item item = new Item();
        item.setName(product.getName());
        item.setUnitPrice(product.getPrice());
        item.setProduct(product);

        return item;
    }
}
