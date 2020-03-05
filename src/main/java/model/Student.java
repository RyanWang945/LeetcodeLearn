package model;

/**
 * @author Ryan
 * @date 2020/3/3 9:51
 */
public class Student {
    private String userid;
    private String name;
    private Integer age;
    private String password;

    public Student() {
    }

    public Student(String userid, String name, Integer age, String password) {
        this.userid = userid;
        this.name = name;
        this.age = age;
        this.password = password;
    }

    /**
     * 获取
     * @return userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置
     * @param userid
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        //this可以省略不写
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "Student{userid = " + userid + ", name = " + name + ", age = " + age + ", password = " + password + "}";
    }
}
