package com.solution.goncharova;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Goncharova Anna
 */
public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        TestBean testBean = context.getBean("testBean", TestBean.class);

        System.out.println(testBean.getName());

        context.close();
    }
}