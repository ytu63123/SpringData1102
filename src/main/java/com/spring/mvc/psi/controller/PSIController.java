package com.spring.mvc.psi.controller;

import com.spring.mvc.psi.entities.Product;
import com.spring.mvc.psi.entities.Purchase;
import com.spring.mvc.psi.entities.Sales;
import com.spring.mvc.psi.repository.Inventory2Repository;
import com.spring.mvc.psi.repository.InventoryRepository;
import com.spring.mvc.psi.repository.ProductRepository;
import com.spring.mvc.psi.repository.PurchaseRepository;
import com.spring.mvc.psi.repository.SalesRepository;
import java.util.Optional;
import org.springframework.util.MultiValueMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/psi")
public class PSIController {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private Inventory2Repository inventory2Repository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private SalesRepository salesRepository;

    @GetMapping(value = {"/product", "/product/{id}", "/product/{name}/{id}"})
    public String readProduct(Model model,
            @RequestParam Optional<Boolean> deleteError,
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
        model.addAttribute("deleteError", deleteError.isPresent() ? "刪除失敗，已有商品購買紀錄，不能刪除" : "");
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
        try {
            productRepository.delete(product.getId());
        } catch (Exception e) {
            return "redirect: ../product?deleteError=true";
        }
        return "redirect: ../product";

    }
//讀取庫存

    @GetMapping(value = {"/inventory"})
    public String readInventory(Model model) {
        model.addAttribute("inventories", inventoryRepository.findAll());
        model.addAttribute("inventories2", inventory2Repository.findAll());

        return "psi/inventory";
    }
//讀取進貨

    @GetMapping(value = {"/purchase"})
    public String readPurchase(Model model) {
        model.addAttribute("purchases", purchaseRepository.findAll());
        model.addAttribute("inventories2", inventory2Repository.findAll());

        return "psi/purchase";
    }
//進貨
    @PostMapping(value = {"/purchase"},
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createPurchase(@RequestBody MultiValueMap<String, String> map) {
        Integer pid = Integer.parseInt(map.getFirst("pid"));
        Integer quantity = Integer.parseInt(map.getFirst("quantity"));
        Integer price = Integer.parseInt(map.getFirst("price"));
        Purchase purchase = new Purchase();
        purchase.setProduct(productRepository.findOne(pid));
        purchase.setPrice(price);
        purchase.setQuantity(quantity);
        purchaseRepository.saveAndFlush(purchase);
        return "redirect: ../psi/purchase";
    }

//讀取銷貨
    @GetMapping(value = {"/sales"})
    public String readSales(Model model) {
        model.addAttribute("sales", salesRepository.findAll());
        model.addAttribute("inventories2", inventory2Repository.findAll());

        return "psi/sales";
    }
//銷貨
    @PostMapping(value = {"/sales"},
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createSales(@RequestBody MultiValueMap<String, String> map) {
        Integer pid = Integer.parseInt(map.getFirst("pid"));
        Integer quantity = Integer.parseInt(map.getFirst("quantity"));
        Integer price = Integer.parseInt(map.getFirst("price"));
        Sales sales = new Sales();
        sales.setProduct(productRepository.findOne(pid));
        sales.setPrice(price);
        sales.setQuantity(quantity);
        salesRepository.saveAndFlush(sales);
        return "redirect: ../psi/sales";
    }

}
