package com.lgc.jvm;

/**
 * 字符串 + 操作位置
 *
 * @author lgc
 * @create 2020-01-15 9:55 上午
 **/
public class StringLocation {
    public static void main(String[] args) {
        String s = "hello";
        String ss = s + "world";
        System.out.println(ss);
    }
}

/**
 * ➜  jvm git:(master) ✗ javap -c -l StringLocation
 * 警告: 二进制文件StringLocation包含com.lgc.jvm.StringLocation
 * Compiled from "StringLocation.java"
 * public class com.lgc.jvm.StringLocation {
 * public com.lgc.jvm.StringLocation();
 * Code:
 * 0: aload_0
 * 1: invokespecial #1                  // Method java/lang/Object."<init>":()V
 * 4: return
 * LineNumberTable:
 * line 9: 0
 * LocalVariableTable:
 * Start  Length  Slot  Name   Signature
 * 0       5     0  this   Lcom/lgc/jvm/StringLocation;
 * <p>
 * public static void main(java.lang.String[]);
 * Code:
 * 0: ldc           #2                  // String hello  // Push item from run-time constant pool
 * 2: astore_1                                           // Store reference into local variable
 * 3: new           #3                  // class java/lang/StringBuilder
 * 6: dup
 * 7: invokespecial #4                  // Method java/lang/StringBuilder."<init>":()V
 * 10: aload_1
 * 11: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 * 14: ldc           #6                  // String world
 * 16: invokevirtual #5                  // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
 * 19: invokevirtual #7                  // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
 * 22: astore_2
 * 23: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
 * 26: aload_2
 * 27: invokevirtual #9                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
 * 30: return
 * LineNumberTable:
 * line 11: 0
 * line 12: 3
 * line 13: 23
 * line 14: 30
 * LocalVariableTable:
 * Start  Length  Slot  Name   Signature
 * 0      31     0  args   [Ljava/lang/String;
 * 3      28     1     s   Ljava/lang/String;
 * 23       8     2    ss   Ljava/lang/String;
 * }
 * <p>
 * LineNumberTable
 * 指令与代码行数的偏移对应关系
 * 第一个数字对应代码行数
 * 第二个数字对应前面code中指令前面的数字
 * <p>
 * LocalVariableTable
 * 局部变量表
 * start+length表示这个变量在字节码中的生命周期起始和结束的偏移位置（this生命周期从头0到结尾10），
 * slot就是这个变量在局部变量表中的槽位（槽位可复用），
 * name就是变量名称，
 * Signature 局部变量类型描述
 */

/**
 *  LineNumberTable
 *  指令与代码行数的偏移对应关系
 *  第一个数字对应代码行数
 *  第二个数字对应前面code中指令前面的数字
 */

/**
 * LocalVariableTable
 *  局部变量表
 *  start+length表示这个变量在字节码中的生命周期起始和结束的偏移位置（this生命周期从头0到结尾10），
 *  slot就是这个变量在局部变量表中的槽位（槽位可复用），
 *  name就是变量名称，
 *  Signature 局部变量类型描述
 */
