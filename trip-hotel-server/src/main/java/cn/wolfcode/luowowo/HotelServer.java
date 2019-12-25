package cn.wolfcode.luowowo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.wolfcode.luowowo.hotel.mapper")
@EnableDubbo
public class HotelServer {
    public static void main(String[] args){
        SpringApplication.run(HotelServer.class,args);
    }
}
