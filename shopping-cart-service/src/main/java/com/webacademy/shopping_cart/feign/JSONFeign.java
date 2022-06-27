package com.webacademy.shopping_cart.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "postFeignClient", url = "${client.post.baseUrl}")
public interface JSONFeign {

    @GetMapping("/posts")
    List<Post> getAllPosts();
}
