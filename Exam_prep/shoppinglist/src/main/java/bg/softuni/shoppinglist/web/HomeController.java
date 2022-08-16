package bg.softuni.shoppinglist.web;

import bg.softuni.shoppinglist.model.dto.ProductDTO;
import bg.softuni.shoppinglist.model.enums.CategoryTypeEnum;
import bg.softuni.shoppinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;


import javax.validation.Valid;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public String homePage(Model model, ProductDTO productDTO) {
        model.addAttribute("totalPrice", this.productService.getTotalProductsPrice());
        model.addAttribute("foods", productService.findProductsByCategory(CategoryTypeEnum.FOOD, productDTO));
        model.addAttribute("drinks", productService.findProductsByCategory(CategoryTypeEnum.DRINK, productDTO));
        model.addAttribute("households", productService.findProductsByCategory(CategoryTypeEnum.HOUSEHOLD, productDTO));
        model.addAttribute("others", productService.findProductsByCategory(CategoryTypeEnum.OTHER, productDTO));
        return "/home";
    }


}
