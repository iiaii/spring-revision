package me.iiaii.springrevision.practice;

import me.iiaii.springrevision.practice.discount.DiscountPolicy;
import me.iiaii.springrevision.practice.discount.FixDiscountPolicy;
import me.iiaii.springrevision.practice.discount.RateDiscountPolicy;
import me.iiaii.springrevision.practice.member.MemberRepository;
import me.iiaii.springrevision.practice.member.MemberService;
import me.iiaii.springrevision.practice.member.MemberServiceImpl;
import me.iiaii.springrevision.practice.member.MemoryMemberRepository;
import me.iiaii.springrevision.practice.order.OrderService;
import me.iiaii.springrevision.practice.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
