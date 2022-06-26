package com.webacademy.shopping_cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "jplaceholder", url = "https://jsonplaceholder.typicode.com/")
public interface HomeFeignClient {

    @GetMapping("/todos")
    List<com.neusoft.Models.Todos> getAllTodos();

    @GetMapping("/todos/{id}")
    com.neusoft.Models.Todos getTodoById(@PathVariable("id") Long id);
}
