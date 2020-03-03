package com.lgc.jdk8;

import com.sun.tools.javac.util.Assert;

import java.util.Optional;

/**
 * @author lgc
 **/
public class OptionalDemo {
    public static void main(String[] args) {
        //createEmptyOptional();
//        createInstance();
        orElse();
//        changeValue();
    }

    static void createEmptyOptional() {
        Optional<Object> empty = Optional.empty();
        Object o = empty.get();
        System.out.println(empty);
    }

    static void createInstance() {
        User user = User.builder().name("optional").build();
        //of 调用 object.requireNonNull 抛出null exception
        Optional<User> opt = Optional.of(user);
        System.out.println(opt);
        System.out.println(opt.get().getName());
        //of nullable 允许为空 为空返回 empty()
        Optional<User> user1 = Optional.ofNullable(null);
        System.out.println(user1);
        System.out.println(Optional.empty());
        //验证是否有值 isPresent this.value !=null
        Assert.check(opt.isPresent());
        opt.ifPresent((u -> Assert.check(u.getName().length() > 2)));
        //orElse 如果有值返回 为空返回 入参
        User user2 = Optional.ofNullable(user).orElse(user);
    }

    static void orElse() {
        /**
         * this.value != null ? value : other
         * orElse 为空执返回执行 T orElse 不为空也会执行
         */
        User opt = User.builder().name("opt").build();
        User user = null;
        User user1 = Optional.ofNullable(opt).orElse(log());
        System.out.println("orElse 不为空" + user1);
        User user2 = Optional.ofNullable(user).orElse(log());//orElse 为空执返回执行 T
        System.out.println("orElse 为空" + user2);
        User user3 = Optional.ofNullable(opt).orElseGet(() -> log());
        System.out.println("orELseGet不为空" + user3);
        User user4 = Optional.ofNullable(user).orElseGet(() -> log());
        System.out.println("orElseGet为空" + user4);
        System.out.println(Optional.ofNullable(user).orElseThrow(()->new RuntimeException("npe")));
        /**
         * user log
         * User(id=null, name=opt, phone=null, email=null)
         * user log
         * User(id=1, name=null, phone=null, email=null)
         * ------
         * User(id=null, name=opt, phone=null, email=null)
         * ------
         * user log
         * User(id=1, name=null, phone=null, email=null)
         */
    }


    private static User log() {
        System.out.println("user log");
        return User.builder().id(1L).build();
    }

    /**
     * map 返回被optional包装
     * flatMap 返回optional类型
     */
    static void changeValue() {
        User user = User.builder().build();
//        User user = null;
        User change = Optional.ofNullable(user).map(c -> {
                    c.setName(Optional.ofNullable(c.getName()).orElse("change"));
                    return c;
                }
        ).orElse(User.builder().name("else").build());
        String email = Optional.ofNullable(user).map(User::getEmail).orElse("default@gmail.com");
        Optional<User> optionalUser = Optional.of(user);
//        optionalUser.flatMap(OptionalDemo::flatMapMethod)
        System.out.println(email);

        Optional<String> s = Optional.of("input");
        System.out.println(s.map(OptionalDemo::getOutput));
        System.out.println(s.flatMap(OptionalDemo::getOutputOpt));
    }


    static Optional<User> flatMapMethod() {
        return Optional.ofNullable(User.builder().build());
    }


    static Optional<String> getOutput(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }

    static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }
}