package com.will.util.core;

/**
 * ClassName:AssertUtil
 * Description:断言工具类
 *
 * @Author wuguanghui
 * @Email willWu618@gmail.com
 * @Date 2019/8/24 18:12
 */
@SuppressWarnings("unused")
public class AssertUtil {
    /**
     * t不能为空
     *
     * @param t
     * @param message
     */
    public static <T> void notNull(T t, String message) {
        if (null == t) {
            throw new RuntimeException(message);
        }
    }
}
