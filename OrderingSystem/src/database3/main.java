package database3;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.Vector;

/**
 * 类名:     main
 * 描述:
 * 隶属于:   OrderingSystem
 * 建立事件： 2022/7/26
 * 作者：    llonvne
 * 邮箱：    Work@llonvne.cn
 * Copyright (c) 2022,All rights reserved.
 */
public class main {

    static class IterableIterator<E> implements Iterable<E> {

        private final Iterator<E> iterator;

        public IterableIterator(Iterator<E> iterator) {
            this.iterator = iterator;
        }

        @NotNull
        @Override
        public Iterator<E> iterator() {
            return iterator;
        }
    }

    public static void main(String[] args) {
        //123
    }

    Vector<Integer> a;
}
