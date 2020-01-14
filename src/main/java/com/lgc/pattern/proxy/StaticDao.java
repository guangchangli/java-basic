package com.lgc.pattern.proxy;

import com.lgc.pattern.BaseDao;

/**
 * @author lgc
 * @create 2020-01-14 10:21 上午
 **/
public class StaticDao implements BaseDao {
    @Override
    public void base() {
        System.out.println("origin dao implements by staticDao");
    }
}
