package com.lgc.basic.abstact;

/**
 * @author lgc
 **/
public class AbstractDemo {
    /**
     * 抽象类
     * 实例变量，类变量，实例方法，类方法以及抽象方法，
     * 构造方法，常量，抽象类不能被实例化，子类继承抽象类，
     * 要么实现抽象方法，要么子类也是抽象类。
     * 接口
     * 接口不是类，而是对类的一组需求的描述，子类要遵守从接口描述的统一格式进行定义。
     * 接口中只能包含常量和抽象方法，静态方法和默认方法，
     * 其中常量的修饰符只能有pubic static final,并且可以省略，
     * 抽象方法的修饰只能有public abstract 和default，也可以省略
     * 子类重写接口抽象方法时必须使用public修饰。
     */
    /**
     * 如果一个子类实现了某个接口，接口又继承了另一个接口，
     * 子类重写默认方法时，如果需要调用父类默认方法，
     * 只能调用子类直接实现的接口的方法（就近原则）
     */
}

abstract class Ab {
    private int id;
    static final String a = "AB";

    void abn(){

    }
    public Ab(int id) {
        this.id = id;
    }

    public Ab() {
    }
}

interface I {
    public static final String i = "I";

    public abstract void i();

    default void iI() {

    }
}
interface I2{
    void i();
}
class t extends Ab implements I,I2{

    @Override
    public void i() {

    }

}
