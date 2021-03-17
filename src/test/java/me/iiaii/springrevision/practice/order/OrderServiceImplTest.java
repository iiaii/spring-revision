package me.iiaii.springrevision.practice.order;

import me.iiaii.springrevision.practice.discount.FixDiscountPolicy;
import me.iiaii.springrevision.practice.discount.RateDiscountPolicy;
import me.iiaii.springrevision.practice.member.Grade;
import me.iiaii.springrevision.practice.member.Member;
import me.iiaii.springrevision.practice.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    // 생성자 주입을 해야하는 이유
    // 1. 생성자 주입을 하면 nullpointerException에서 자유롭고 불변 객체를 만들 수 있음
    // 2. 생성자 주입을 하면 final 키워드를 먹일 수 있음
    @Test
    @DisplayName("createOrder")
    public void createOrder() throws Exception {
        // given

        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "멤버", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
        Order order = orderService.createOrder(1L, "name", 1000);


        // when


        // then
        assertThat(order.getDiscountPrice()).isEqualTo(100);
    }
}