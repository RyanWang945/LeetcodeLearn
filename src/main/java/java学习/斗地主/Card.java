package java学习.斗地主;

/**
 * @author Ryan
 * @date 2020/3/26 9:22
 */
public class Card {
    private String number;
    private String color;

    public Card() {
    }

    public Card(String number, String color) {
        this.number = number;
        this.color = color;
    }

    /**
     * 获取
     * @return number
     */
    public String getNumber() {
        return number;
    }

    /**
     * 设置
     * @param number
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * 获取
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * 设置
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Card{number = " + number + ", color = " + color + "}";
    }
}
