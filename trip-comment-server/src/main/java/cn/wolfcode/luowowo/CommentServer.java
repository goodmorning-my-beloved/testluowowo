package cn.wolfcode.luowowo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class CommentServer {
    public static void main(String[] args) {
        SpringApplication.run(CommentServer.class, args);
    }
}
