package com.spring.mvc.psi.controller;

import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.repository.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/psi")
public class PSIController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping(value = {"/product", "/product/{id}", "/product/{name}/{id}"})
    public String readProduct(Model model,
            @PathVariable Optional<Integer> id,
            @PathVariable Optional<String> name) {
        String _method = "POST";
        Product product = new Product();
        if (id.isPresent()) {
            product = productRepository.findOne(id.get());
            _method = "PUT";
            if (name.isPresent() && name.get().equals("delete")) {
                _method = "DELETE";
            }
        }
        model.addAttribute("_method", _method);
        model.addAttribute("product", product);
        model.addAttribute("products", productRepository.findAll());
        return "psi/product";
    }

    @PostMapping(value = {"/product"})
    public String createProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect: ../product";
    }

    @PutMapping(value = {"/product"})
    public String updateProduct(@ModelAttribute("product") Product product) {
        productRepository.saveAndFlush(product);
        return "redirect: ../product";
    }

    @DeleteMapping(value = {"/product"})
    public String deleteProduct(@ModelAttribute("product") Product product) {
        productRepository.delete(product.getId());
        return "redirect: ../product";
    }

}
