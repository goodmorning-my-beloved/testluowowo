package cn.wolfcode.luowowo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDubbo
//@EnableScheduling  //启动定时任务支持
public class MgrSite {
    public static void main(String[] args) {
        SpringApplication.run(MgrSite.class, args);
    }
}
