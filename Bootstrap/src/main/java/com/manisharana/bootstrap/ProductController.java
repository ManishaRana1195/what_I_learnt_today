package com.manisharana.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService productService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getAllProducts(){
        return productService.findAll();
    }

    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable("id") Long productId){
        return productService.getProduct(productId);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public Long saveProduct(@RequestBody Product product){
        return productService.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }


}
