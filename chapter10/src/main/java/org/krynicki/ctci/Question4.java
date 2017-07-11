package org.krynicki.ctci;

/**
 * Created by kamil.krynicki on 06/07/2017.
 */
public class Question4 {

    public int find(Listy data, int key) {
        if (key < 0)
            return -1;
        else
            return find(data, key, 0, 1);
    }

    private int find(Listy data, int key, int from, int to) {
        if (from == to)
            return -1;

        int mid = (to + from) / 2;

        if (data.elementAt(mid) == key)
            return mid;

        if (data.elementAt(mid) > key || data.elementAt(mid) == -1)
            return find(data, key, from, mid);

        if (data.elementAt(mid) < key && data.elementAt(to) > key)
            return find(data, key, mid + 1, to);

        return find(data, key, mid + 1, 2 * to - from);
    }

    public static class Listy {
        private final int[] data;
        private final int size;

        public Listy(int... data) {
            this.size = data.length;
            this.data = new int[size];

            System.arraycopy(data, 0, this.data, 0, this.size);
        }

        public int elementAt(int i) {
            if (insideBounds(i))
                return data[i];
            else
                return -1;
        }

        private boolean insideBounds(int i) {
            return i < this.size;
        }
    }

}
