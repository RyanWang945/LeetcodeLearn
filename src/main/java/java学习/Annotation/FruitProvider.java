package java学习.Annotation;

import java.lang.annotation.*;

/**
 * @author Ryan
 * @date 2020/4/11 18:36
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    int id() default -1;
    String name() default "";
    String address() default "";
}
