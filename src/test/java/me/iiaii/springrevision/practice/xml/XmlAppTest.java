package me.iiaii.springrevision.practice.xml;

import me.iiaii.springrevision.practice.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlAppTest {

    @Test
    public void xmlAppConfigTest() throws Exception {
        // given
        GenericXmlApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        // when


        // then
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
