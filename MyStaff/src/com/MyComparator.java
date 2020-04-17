package com;

import java.util.Comparator;
/*
 * @author  Inn
 * @version 1.0
 * 实现比较类，按照放在五线谱上的x值，可对Shape数组进行排序
 */
class MyComparator implements Comparator<Shape>{
    @Override
    public int compare(Shape a, Shape b) {
        return a.getX()-b.getX();
    }
}
