package com.example.kingdom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching /* キャッシュを有効にする */
public class KingdomProjectApplication {
    public static void main(String[] args) {
        SpringApplication.run(KingdomProjectApplication.class, args);
    }

}
