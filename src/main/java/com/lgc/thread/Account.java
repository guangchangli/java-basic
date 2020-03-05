package com.lgc.thread;

import java.util.concurrent.TimeUnit;

/**
 * 脏读
 * @author lgc
 **/
public class Account {
    private String name;
    private double balance;

    public synchronized double getBalance() {
        return balance;
    }

    public synchronized void setBalance(String name,double balance) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
        this.name=name;
    }

    public static void main(String[] args) {
        Account account = new Account();
        new Thread(()->account.setBalance("l",100)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance());
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance());
    }

}
