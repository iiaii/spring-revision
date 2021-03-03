package me.iiaii.springrevision.practice.discount;

import me.iiaii.springrevision.practice.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 힐인 대상 금액
     */
    int discount(Member member, int price);
}
