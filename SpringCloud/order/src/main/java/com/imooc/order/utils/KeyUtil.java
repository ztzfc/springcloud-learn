package com.imooc.order.utils;

import java.util.Random;

public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间戳+随机数
     */

    public static String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000)+100000;

        String time = "";
        synchronized (KeyUtil.class){
            time = System.currentTimeMillis()+"";
        }

        return time + String.valueOf(number);
    }
}
