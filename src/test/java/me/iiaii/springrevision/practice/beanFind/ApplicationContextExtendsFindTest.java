package me.iiaii.springrevision.practice.beanFind;

import me.iiaii.springrevision.practice.discount.DiscountPolicy;
import me.iiaii.springrevision.practice.discount.FixDiscountPolicy;
import me.iiaii.springrevision.practice.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘이상이면, 중복 오류가 발생")
    public void findBeanByParentTypeDuplicated() throws Exception {
        // given


        // when


        // then
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
                ac.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘이상이면, 빈 이름 정하면 테스트 통과")
    public void findBeanByParentTypeBeanName() throws Exception {
        // given
        DiscountPolicy policy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);

        // when


        // then
        assertThat(policy).isInstanceOf(RateDiscountPolicy.class);
    }
    
    @Test
    @DisplayName("특정 하위 타입으로 조회")        
    public void findBeanBySubType() throws Exception {
        // given
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);

        // when
        
        
        // then
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")        
    public void findAllBeanByParentType() throws Exception {
        // given
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);

        // when
        
        
        // then
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key +" value = " + beansOfType.get(key));
        }
        assertThat(beansOfType.size()).isEqualTo(2);
    }
    
    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    public void findAllBeanByObject() throws Exception {
        // given
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);

        // when
        
        
        // then
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }


    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }

    }

}
