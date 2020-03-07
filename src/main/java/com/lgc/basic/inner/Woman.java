package com.lgc.basic.inner;

/**
 * 外部内  * @author zl
 */
public class Woman {
    private int age;

    public Woman(int age) {
        super();
        this.age = age;
    }

    public void create() {
        Baby baby = new Baby("安琪拉", 3);
        System.out.println(baby.name);
    }

    /**
     * 非静态内部类   * @author zl   *
     */
    public class Baby {
        int age;
        String name;

        public Baby() {
        }

        public Baby(String name, int age) {
            super();
            System.out.println("执行了Baby内部类的构造方法");
            this.name = name;
            this.age = age;
        }

        public void visited() {
            //访问外部类成员变量
            System.out.println("woman age is==========" + Woman.this.age);
            //访问内部类成员变量
            System.out.println("woman age is==========" + this.age);
        }
    }
}

//测试类
class Test {
    public static void main(String[] args) {
        Woman woman = new Woman(19);
        Woman.Baby baby = woman.new Baby("小糯米", 2);
        baby.visited();
    }
}