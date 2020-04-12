package java学习.Annotation;

import java.lang.annotation.*;

/**
 * @author Ryan
 * @date 2020/4/11 18:29
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    enum Color{BLUE,RED,GREEN}
    Color fruitColor() default  Color.GREEN;
}
