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

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
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
