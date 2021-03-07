package me.iiaii.springrevision.practice.beanFind;

import me.iiaii.springrevision.practice.AppConfig;
import me.iiaii.springrevision.practice.member.MemberService;
import me.iiaii.springrevision.practice.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")        
    public void findBeanByName() throws Exception {
        // given
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        
        // when
        
        
        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회 (DIP에 의해 좋은 코드는 아님)")
    public void findBeanByName2() throws Exception {
        // given
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

        // when


        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입 이름으로만 조회")
    public void findBeanByType() throws Exception {
        // given
        MemberService memberService = ac.getBean(MemberService.class);

        // when


        // then
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")        
    public void findBeanByName_X() throws Exception {
        // given


        // when


        // then
        Assertions.assertThrows(NoSuchBeanDefinitionException.class, () ->
            ac.getBean("xxx", MemberService.class)
        );
    }
}
