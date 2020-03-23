package cn.tedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 搜索查询
 *
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("cn.tedu.search.mapper")
public class StarterSearch {
    public static void main( String[] args ) {
        SpringApplication.run(StarterSearch.class,args);
    }
}
