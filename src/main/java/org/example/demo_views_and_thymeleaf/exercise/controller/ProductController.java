package org.example.demo_views_and_thymeleaf.exercise.controller;

import org.example.demo_views_and_thymeleaf.exercise.model.Product;
import org.example.demo_views_and_thymeleaf.exercise.service.ProductService;
import org.example.demo_views_and_thymeleaf.exercise.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/exercise/products")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping()
    public String index(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "exercise/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "exercise/create";
    }

    @PostMapping("/save")
    public String save(Product customer, RedirectAttributes redirect) {
        customer.setId((int) (Math.random() * 10000));
        productService.save(customer);
        redirect.addFlashAttribute("success", "Added customer successfully!");
        return "redirect:/exercise/products";
    }

    @GetMapping("/{id}/edit")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "exercise/update";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product.getId(), product);
        redirect.addFlashAttribute("success", "Updated customer successfully!");
        return "redirect:/exercise/products";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "exercise/delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.remove(product.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/exercise/products";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "exercise/view";
    }
}
