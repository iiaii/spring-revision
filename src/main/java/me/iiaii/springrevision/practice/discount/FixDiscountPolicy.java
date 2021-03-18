package me.iiaii.springrevision.practice.discount;

import me.iiaii.springrevision.practice.annotation.SubDiscountPolicy;
import me.iiaii.springrevision.practice.member.Grade;
import me.iiaii.springrevision.practice.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@SubDiscountPolicy
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }

        return 0;
    }
}
