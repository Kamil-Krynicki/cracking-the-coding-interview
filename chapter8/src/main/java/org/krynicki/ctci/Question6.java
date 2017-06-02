package org.krynicki.ctci;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by kamil.krynicki on 02/06/2017.
 */
public class Question6 {
    public HanoiStack[] printSolutionForHanoi(int diskCount) {
        HanoiStack[] stacks = new HanoiStack[3];

        stacks[0] = new HanoiStack("1");
        stacks[1] = new HanoiStack("2");
        stacks[2] = new HanoiStack("3");

        for (int i = diskCount; i > 0; i--) {
            stacks[0].push(i);
        }

        move(diskCount, stacks[0], stacks[2], stacks[1]);

        return stacks;
    }

    private void move(int diskCount, HanoiStack from, HanoiStack to, HanoiStack buffer) {
        //System.out.println("Moving " + diskCount + " disks from " + from.name() + " to " + to.name());
        if (diskCount == 1) {
            to.push(from.pop());
        } else {
            move(diskCount - 1, from, buffer, to);
            move(1, from, to, buffer);
            move(diskCount - 1, buffer, to, from);
        }
    }

    class HanoiStack {
        private Deque<Integer> storage = new LinkedList<>();
        private String name;

        private HanoiStack(String name) {
            this.name = name;
        }

        public boolean isEmpty() {
            return storage.isEmpty();
        }

        public boolean canPop() {
            return !isEmpty();
        }

        public boolean canPush(int value) {
            return isEmpty() || storage.peek() > value;
        }

        public int pop() {
            if (!canPop())
                throw new IllegalArgumentException();

            return storage.pop();
        }

        public void push(int value) {
            if (!canPush(value))
                throw new IllegalArgumentException();

            storage.push(value);
        }

        public String name() {
            return name;
        }
    }
}
