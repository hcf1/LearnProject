package other;

/**
 * 匿名内部类为什么持有外部类的引用
 * 内部类会生成InnerClass$1NewAge
 * 加 final 就直接将 defaultAge 的 5 直接给复制过去。否则就是直接引用 this$0.defaultAge
 */
public class InnerClass {

    public static void main(String[] args) {
        new InnerClass().addAge(44);
    }

    private final Object defaultAge = "5";

    // 局部变量 age，必须添加final关键字，这里先不加
    public void addAge(int age) {

        //局部内部类
        class NewAge {
            private String getAge() {
                return age + defaultAge.toString();
            }
        }

        NewAge newAge = new NewAge();
        System.out.print(newAge.getAge());
    }
}
