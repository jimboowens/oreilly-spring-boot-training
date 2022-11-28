package com.oreilly.demo;

import com.oreilly.demo.json.Greeting;
//import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

//@Slf4j
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    void contextLoads() {
        assertNotNull(context);
//        log.info(context.getClass().getName());
        System.out.println("context: [" + context.getClass().getName() + "]");
        int count = context.getBeanDefinitionCount();
        System.out.println("there are [" + count + "] beans in the applicationContext.");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(
//                name->{
//           System.out.println("name: ["+name+"]");
//        });
                System.out::println);
    }

    @Test
    @Disabled
        // disabled because transitioned to @Component in Greeting class
    void noGreetingInAppCtx() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> context.getBean(Greeting.class));
    }

    @Test
    void getBeanTwice() {
        // will fail if Greeting left as component AND defaultGreeting created
        // one fix to allow the Greeting class to be a component AND have other Greeting classes exist is to specify
        // the name when getting the bean from the context.
        Greeting greeting1 = context.getBean("defaultGreeting", Greeting.class);
        Greeting greeting2 = context.getBean("whatUpGreeting", Greeting.class);

//        greeting1.setMessage("what up");

        System.out.println("greeting2.getMessage(): [" + greeting2.getMessage() + "]");

        assertNotSame(greeting1, greeting2);
    }

}
