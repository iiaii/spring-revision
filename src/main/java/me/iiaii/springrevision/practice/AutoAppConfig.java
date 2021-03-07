package me.iiaii.springrevision.practice;

import me.iiaii.springrevision.practice.member.MemberRepository;
import me.iiaii.springrevision.practice.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)  // @Component 를 찾아 등록 (제외하는 예제)
public class AutoAppConfig {

    // 수동 등록된 빈이 우선권을 가진다 (스프링 부트에서는 오류되도록 됨)
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
