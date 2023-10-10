package com.example.core.autowired;

import com.example.core.member.Member;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoWiredTest {
  @Test
  void AutowiredOption(){
    ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

  }

  static class TestBean{

    //호출 안됨
    @Autowired(required = false)
    public void setNoBean1(Member member) {
      System.out.println("setNoBean1 = " + member);
    }
    //null 호출
    @Autowired
    public void setNoBean2(@Nullable Member member) {
      System.out.println("setNoBean2 = " + member);
    }
    //Optional.empty 호출
    @Autowired(required = false)
    public void setNoBean3(Optional<Member> member) {
      System.out.println("setNoBean3 = " + member);
    }
  }
}
