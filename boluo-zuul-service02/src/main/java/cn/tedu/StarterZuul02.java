package cn.tedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//开启zuul网关的注解
@EnableZuulProxy
@EnableEurekaClient
public class StarterZuul02 {
    public static void main(String[] args) {
        SpringApplication.run(StarterZuul02.class,args);
    }
}
