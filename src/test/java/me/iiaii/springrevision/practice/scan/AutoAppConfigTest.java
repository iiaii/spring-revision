package me.iiaii.springrevision.practice.scan;

import me.iiaii.springrevision.practice.AutoAppConfig;
import me.iiaii.springrevision.practice.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    public void beanScan() throws Exception {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);

        // when


        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
