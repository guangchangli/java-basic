package com.lgc.pattern.proxy;

import com.lgc.pattern.BaseDao;

/**
 * @author lgc
 * @create 2020-01-14 10:22 上午
 **/
public class StaticProxyDao implements BaseDao {

    private StaticDao baseDao;

    public StaticProxyDao(StaticDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public void base() {
        System.out.println("静态代理什么玩意儿");
        baseDao.base();
        System.out.println("静态代理，维护一个原始代理对象，在不改变原始对象方法的前提下，进行拓展，" +
                "每次都要新建一个实现类，实现相同的接口，实际还是用被代理对象调用方法");
    }

    public static void main(String[] args) {
        StaticDao staticDao = new StaticDao();
        StaticProxyDao staticProxyDao = new StaticProxyDao(staticDao);
        staticProxyDao.base();
    }
}
