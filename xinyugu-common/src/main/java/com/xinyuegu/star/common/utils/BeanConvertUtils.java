package com.xinyuegu.star.common.utils;

import java.util.List;

/**
 * @author hxy
 * @time 2017/12/20
 * @desc
 */
public abstract class BeanConvertUtils<A, B> {
    /**
     * bean 属性值拷贝正向
     * @param a 待拷贝的对象
     * @return 拷贝后目标值
     * @author hxy
     */
    protected abstract B doForward(A a);
    /**
     * bean 属性值拷贝逆向
     * @param b 待拷贝的对象
     * @return 拷贝后目标值
     * @author hxy
     */
    protected abstract A doBackward(B b);
    /**
     * bean 属性值拷贝逆向List
     * @param list 待拷贝的对象
     * @return 拷贝后目标值
     * @author hxy
     */
    protected abstract List<B> doForwardList(List<A> list);
    /**
     * bean 属性值拷贝逆向List
     * @param list 待拷贝的对象
     * @return 拷贝后目标值
     * @author hxy
     */
    protected abstract List<A> doBackwardList(List<B> list);
}
