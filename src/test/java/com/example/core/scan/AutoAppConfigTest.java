package com.example.core.scan;

import static org.junit.jupiter.api.Assertions.*;

import com.example.core.AutoAppConfig;
import com.example.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import
    org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.*;
public class AutoAppConfigTest {
  @Test
  void basicScan() {
    ApplicationContext ac = new
        AnnotationConfigApplicationContext(AutoAppConfig.class);
    MemberService memberService = ac.getBean(MemberService.class);
    assertThat(memberService).isInstanceOf(MemberService.class);
  }
}