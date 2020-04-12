package java学习.Annotation;

import java.lang.annotation.*;

/**
 * @author Ryan
 * @date 2020/4/11 18:25
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
