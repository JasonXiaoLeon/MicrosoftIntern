package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.demo.week2.Press;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //id -> bean
        Press press = (Press)context.getBean("press");
        System.out.println(press);
        //type -> bean
        Press press2= context.getBean(Press.class);
        System.out.println(press2);
        //id & type -> bean
        Press press3 = context.getBean("press", Press.class);
        System.out.println(press3);
//        Class c = Class.forName("com.example.demo.week2.Comment");
//        Comment comment = (Comment)c.getDeclaredConstructor().newInstance();
//        System.out.println(comment);

    }

}
