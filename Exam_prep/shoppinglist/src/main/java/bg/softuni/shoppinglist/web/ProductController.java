package bg.softuni.shoppinglist.web;

import bg.softuni.shoppinglist.model.dto.AddProductDTO;
import bg.softuni.shoppinglist.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ModelAttribute("addProductDTO")
    public AddProductDTO initAddProductDTO() {
        return new AddProductDTO();
    }


    @GetMapping("/add")
    public String addProductPage() {
        return "product-add";
    }

    @PostMapping("/add")
    public String addProduct(@Valid AddProductDTO addProductDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addProductDTO", addProductDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addProductDTO", bindingResult);
            return "redirect:/products/add";
        }

        productService.addProduct(addProductDTO);
        return "redirect:/home";
    }


}