package com.murphy.util;

import java.util.Random;

/**
 * 随机生成六位数 - 账号
 *
 * @author murphy
 * @since 2021/8/9 1:17 上午
 */
public class RandomLoginName {

    private static Random r = new Random();

    /**
     * 随机生成账号名
     * @return
     */
    public static Integer getRandomLoginName() {
        return r.nextInt(900000) + 100000;
    }
}
