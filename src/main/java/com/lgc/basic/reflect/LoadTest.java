package com.lgc.basic.reflect;

/**
 * （1）加载：java类运行时候会生成一个class字节码文件，加载的过程就是去我们的操作系统寻找这个class文件。
 *
 * （2）链接：这个过程就是把class文件加载到java虚拟机。
 *
 * （3）初始化：在虚拟机中根据class文件进行初始化。
 *
 * （4）使用：
 *
 * （5）卸载：使用完了，java虚拟机进行清理。
 *
 *  Class.forName() 初始化了类
 *  classLoader 只是加载了类
 */
public class LoadTest {
    public static void main(String[] args) {
        String user = "com.lgc.basic.reflect.User";
        test(user);
    }   
    public static void test(String user) {
        try {
            ClassLoader loader = ClassLoader.getSystemClassLoader();
            System.out.println("classloader testing...");
            Class<?> loaderUser = loader.loadClass(user);
            System.out.println("user " + loaderUser.getName());
            System.out.println("---------------------------------------"); 
            Class forNameUser = Class.forName(user);
            System.out.println("Class.forName testing...");
            System.out.println("user " + forNameUser.getName());
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}