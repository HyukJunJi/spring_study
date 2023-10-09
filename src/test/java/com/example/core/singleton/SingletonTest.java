package com.example.core.singleton;

import com.example.core.AppConfig;
import com.example.core.member.Member;
import com.example.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;


public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService = appConfig.memberService();
        //2.조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService);
        System.out.println("memberService1 = " + memberService1);

        //memberServie != memberService2
        assertThat(memberService1).isNotSameAs(memberService);



    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonService(){
        SingletonService singletonService = SingletonService.getInstance();
        SingletonService singletonService1 = SingletonService.getInstance();

        System.out.println("singletonService = " + singletonService);
        System.out.println("singletonService1 = " + singletonService1);

        assertThat(singletonService1).isSameAs(singletonService);
        //same ==
        // equal
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
//        AppConfig appConfig = new AppConfig();
        ApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService);
        System.out.println("memberService2 = " + memberService1);

        //memberServie != memberService2
        assertThat(memberService1).isSameAs(memberService);



    }
}
