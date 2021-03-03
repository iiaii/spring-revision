package me.iiaii.springrevision.practice.order;

import me.iiaii.springrevision.practice.AppConfig;
import me.iiaii.springrevision.practice.member.Grade;
import me.iiaii.springrevision.practice.member.Member;
import me.iiaii.springrevision.practice.member.MemberService;
import me.iiaii.springrevision.practice.member.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
