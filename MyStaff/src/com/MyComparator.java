package com;

import java.util.Comparator;
/*
 * @author  Inn
 * @version 1.0
 * ʵ�ֱȽ��࣬���շ����������ϵ�xֵ���ɶ�Shape�����������
 */
class MyComparator implements Comparator<Shape>{
    @Override
    public int compare(Shape a, Shape b) {
        return a.getX()-b.getX();
    }
}
