package jmp.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class App {
	
    public static void main(String[] args) {
    	ApplicationContext ctx = SpringApplication.run(App.class, args); 
        Test test = ctx.getBean(Test.class);
        test.test();
    }
}