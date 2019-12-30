package ObjectDemo;

import java.util.Objects;

public class objectTest {
    //定义一个变量，默认其值为空
    static objectTest obj;
    public static void main(String[] args) {
        System.out.println(Objects.hashCode(obj));
        System.out.println(Objects.toString(obj));
        System.out.println(Objects.requireNonNull(obj,"不能为空"));

    }
}
