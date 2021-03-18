package me.iiaii.springrevision.practice;

import me.iiaii.springrevision.practice.discount.DiscountPolicy;
import me.iiaii.springrevision.practice.discount.RateDiscountPolicy;
import me.iiaii.springrevision.practice.member.MemberRepository;
import me.iiaii.springrevision.practice.member.MemberService;
import me.iiaii.springrevision.practice.member.MemberServiceImpl;
import me.iiaii.springrevision.practice.member.MemoryMemberRepository;
import me.iiaii.springrevision.practice.order.OrderService;
import me.iiaii.springrevision.practice.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Configuration 은 CGLIB 라이브러리를 사용해서 바이트코드 조작을 하고 @Bean의 싱글톤을 보장해준다 (없으면 생성 있으면 생성한것 가져오도록)
// @Configuration 없이 @Bean 만 사용하면 싱글톤 보장이 안된다
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
