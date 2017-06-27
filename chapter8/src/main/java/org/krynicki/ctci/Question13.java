package org.krynicki.ctci;

import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by kamil.krynicki on 26/06/2017.
 */
public class Question13 {

    Map<Box, Integer> memo;

    public synchronized int maxHeight(List<Box> boxes) {
        Collections.sort(boxes, (o1, o2) -> o1.w - o2.w); //not sure if necessary

        memo = new HashMap<>();

        Box base = new Box(0, Integer.MAX_VALUE, Integer.MAX_VALUE);

        int result = maxHeight(base, new LinkedList<>(boxes));

        memo.clear();

        return result;
    }

    private int maxHeight(Box last, Deque<Box> boxes) {
        if (boxes.isEmpty())
            return 0;

        if (!memo.containsKey(last)) {
            int max = 0;

            for (Box box : new LinkedList<>(boxes)) {
                if (last.isStrictlyBiggerThan(box)) {
                    boxes.remove(box);
                    max = Math.max(max, box.h + maxHeight(box, boxes));
                    boxes.add(box);
                }
            }

            memo.put(last, max);
        }

        return memo.get(last);
    }

    public static final class Box {
        final int h;
        final int w;
        final int d;

        Box(int h, int w, int d) {
            this.h = h;
            this.w = w;
            this.d = d;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Box box = (Box) o;

            return d == box.d && h == box.h && w == box.w;
        }

        @Override
        public int hashCode() {
            int result = h;
            result = 31 * result + w;
            result = 31 * result + d;
            return result;
        }

        public boolean isStrictlyBiggerThan(Box that) {
            return this.w > that.w && this.d > that.d;
        }
    }

}

