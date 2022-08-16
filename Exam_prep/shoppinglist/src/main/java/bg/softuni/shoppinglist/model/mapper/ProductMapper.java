package bg.softuni.shoppinglist.model.mapper;

import bg.softuni.shoppinglist.model.dto.AddProductDTO;
import bg.softuni.shoppinglist.model.dto.ProductDTO;
import bg.softuni.shoppinglist.model.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productDTOToProduct(ProductDTO productDTO);
    Product addProductDTOToProduct(AddProductDTO addProductDTO);
}
