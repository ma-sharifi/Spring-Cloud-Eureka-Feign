package com.tatipati.feign.client.feign;

import com.tatipati.feign.client.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "eureka-client",path = "products"/*, url = "http://localhost:8081"*/)
public interface ProductServiceClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
     List<Product> getAllProducts();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
     Product getProduct(@PathVariable("id") int productId);

}