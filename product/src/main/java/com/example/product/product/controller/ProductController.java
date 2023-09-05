package com.example.product.product.controller;

import com.example.product.product.model.Product;
import com.example.product.product.model.ProductType;
import com.example.product.product.service.IProductService;
import com.example.product.product.service.IProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/api/product")
@CrossOrigin(origins = "*")
public class ProductController {
    @Autowired
    private IProductService productService;
    @Autowired
    private IProductTypeService productTypeService;

    @GetMapping("")
    public ResponseEntity<List<Product>> displayListProduct() {
        return new ResponseEntity<>(productService.getListProduct(), HttpStatus.OK);
    }

    @GetMapping("/types")
    public ResponseEntity<List<ProductType>> displayProductType() {
        return new ResponseEntity<>(productTypeService.getListProductType(),HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<List<Product>> deleteProduct(@PathVariable("id") Integer id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        productService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes) {
        if (productService.deleteProduct(id)) {
            redirectAttributes.addFlashAttribute("message", "Xoá Thành công");
        } else {
            redirectAttributes.addFlashAttribute("message", "Không tìm thấy id");
        }
        return "redirect:/product";
    }

    @PostMapping("/create")
    public ResponseEntity<?> getCreationForm(@RequestBody Product product) {
//        model.addAttribute("songCreationDto", new SongCreationDto());
        try {
            productService.addNewProduct(product);
            return ResponseEntity.status(HttpStatus.OK).body("add success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("add Fail");
        }
    }


    @Transactional
    @GetMapping("/get")
    public ResponseEntity<Page<Product>> getALlProduct(@RequestParam(value = "page", defaultValue = "0") Integer page) {
//        Pageable pageable = PageRequest.of(page, 3, Sort.by(Sort.Order.desc("name")));
        Pageable pageable = PageRequest.of(page, 3, Sort.by(Sort.Order.asc("name")));


        Page<Product> contractsPage = productService.getPage(pageable);

        if (contractsPage == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractsPage, HttpStatus.OK);
    }
}


