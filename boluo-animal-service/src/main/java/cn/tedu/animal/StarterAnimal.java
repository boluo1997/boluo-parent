package cn.tedu.animal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.tedu.animal.mapper")
public class StarterAnimal {
    public static void main(String[] args) {
        SpringApplication.run(StarterAnimal.class,args);
    }
}
