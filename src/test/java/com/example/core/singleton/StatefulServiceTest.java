package com.example.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {


    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = ac.getBean(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);

        //ThreadA: A사용자 10000원 주문
        int userA = statefulService.order("userA", 10000);
        //ThreadB: B사용자 20000원 주문

        int userB = statefulService1.order("userB", 20000);

        //ThreadA: 사용자A 주문 금액 조회
      //  int price = statefulService.getPrice();
        System.out.println("price = " + userA);

        assertThat(userB).isEqualTo(20000);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}