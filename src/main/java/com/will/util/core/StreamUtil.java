package com.will.util.core;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * ClassName:StreamUtil
 * Description:Stream工具类
 *
 * @Author wuguanghui
 * @Email willWu618@gmail.com
 * @Date 2019/8/24 17:53
 */
@SuppressWarnings("unused")
public class StreamUtil {

    /**
     * 根据对象中某个字段去重
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> List<T> distinctByKey(List<T> list, Function<? super T, Object> keyExtractor) {
        List<T> result = list.stream()
                .filter(StreamUtil.distinctByKey(keyExtractor))
                .collect(Collectors.toList());
        return result;
    }

    /**
     * 根据对象中某个字段去重
     *
     * @param keyExtractor
     * @param <T>
     * @return
     */
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * 对象转map
     *
     * @param list list对象
     * @param key  需要转的key
     * @param <T>  value值泛型
     * @param <X>  key泛型
     * @return map
     */
    public static <T, X> Map<X, T> listToMap(List<T> list, Function<T, X> key) {
        return list.stream().collect(Collectors.toMap(key, Function.identity(), (k1, k2) -> k2));
    }
}
