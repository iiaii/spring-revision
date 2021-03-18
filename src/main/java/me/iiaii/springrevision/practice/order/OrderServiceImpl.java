package me.iiaii.springrevision.practice.order;

import me.iiaii.springrevision.practice.annotation.SubDiscountPolicy;
import me.iiaii.springrevision.practice.discount.DiscountPolicy;
import me.iiaii.springrevision.practice.discount.FixDiscountPolicy;
import me.iiaii.springrevision.practice.member.Member;
import me.iiaii.springrevision.practice.member.MemberRepository;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    //    @Qualifier("mainDiscountPolicy")
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, @SubDiscountPolicy DiscountPolicy discountPolicy) {
        System.out.println("discountPolicy = " + (discountPolicy instanceof FixDiscountPolicy));
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository memberRepository() {
        return memberRepository;
    }
}
