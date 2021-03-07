package me.iiaii.springrevision.practice.beanFind;

import me.iiaii.springrevision.practice.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")        
    public void findAllBean() throws Exception {
        // given
        String[] names = ac.getBeanDefinitionNames();

        // when

        // then
        for (String name : names) {
            Object bean = ac.getBean(name);
            System.out.println("name = "+ name +" bean = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    public void findApplicationBean() throws Exception {
        // given
        String[] names = ac.getBeanDefinitionNames();

        // when

        // then
        for (String name : names) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);

            // ROLE_APPLICATION : 직접 등록한 빈
            // ROLE_INFRASTRUCTURE : 스프링 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(name);
                System.out.println("name = "+ name +" bean = " + bean);
            }
        }
    }
}
