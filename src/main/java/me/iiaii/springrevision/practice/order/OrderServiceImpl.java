package me.iiaii.springrevision.practice.order;

import me.iiaii.springrevision.practice.discount.DiscountPolicy;
import me.iiaii.springrevision.practice.discount.RateDiscountPolicy;
import me.iiaii.springrevision.practice.member.Member;
import me.iiaii.springrevision.practice.member.MemberRepository;
import me.iiaii.springrevision.practice.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}