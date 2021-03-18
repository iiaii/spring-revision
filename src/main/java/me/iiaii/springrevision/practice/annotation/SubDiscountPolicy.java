package me.iiaii.springrevision.practice.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

// 웬만하면 spring 이 제공하는 것만 사용할것
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("subDiscountPolicy")
public @interface SubDiscountPolicy {
}
