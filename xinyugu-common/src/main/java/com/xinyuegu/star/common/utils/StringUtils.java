package com.xinyuegu.star.common.utils;

/**
 * @author hxy
 * @date 2017/11/14
 */
public class StringUtils {
    public static boolean isBlank(String target) {
        if (target == null || "".equals(target)) {
            return true;
        }
        return false;
    }

    public static boolean isNotBlank(String target) {
        if (target == null || "".equals(target)) {
            return false;
        }
        return true;
    }

    public static double stringToDouble(String target) throws Exception {
        try {
            if (StringUtils.isBlank(target)) {
                return 0;
            } else {
                return Double.valueOf(target);
            }
        } catch (final Exception e) {
            throw new Exception("string to double error");
        }

    }
}
