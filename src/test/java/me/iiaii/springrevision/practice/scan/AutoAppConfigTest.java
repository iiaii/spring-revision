package me.iiaii.springrevision.practice.scan;

import me.iiaii.springrevision.practice.AutoAppConfig;
import me.iiaii.springrevision.practice.member.MemberRepository;
import me.iiaii.springrevision.practice.member.MemberService;
import me.iiaii.springrevision.practice.order.Order;
import me.iiaii.springrevision.practice.order.OrderServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoAppConfigTest {

    @Test
    public void beanScan() throws Exception {
        // given
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);

        // when


        // then
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.memberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }

    // 필드 자동 의존주입은 값을 넣어줄 방법이 없고 임의 생성시 null pointer exception 발생 가능
    // 필드 인젝션은 쓰지 않는다! (테스트코드에서만 사용)
//    @Test
//    public void fieldInjectionTest() throws Exception {
//        // given
//        OrderServiceImpl orderService = new OrderServiceImpl();
//        Order name = orderService.createOrder(1L, "name", 100);
//
//        // when
//
//
//        // then
//
//    }
}
