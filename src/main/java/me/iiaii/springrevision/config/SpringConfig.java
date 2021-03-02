package me.iiaii.springrevision.config;

import me.iiaii.springrevision.aop.TimeTraceAop;
import me.iiaii.springrevision.repository.MemberRepository;
import me.iiaii.springrevision.repository.MemoryMemberRepository;
import me.iiaii.springrevision.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }
}
