package ddf.p07_stack;

import utils.DUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个栈实现一个队列，支持队列的基本操作：add, poll, peek
 */
public class C22_TwoStackToQueue {

    private static class DdfQueue {

        private Stack<Integer> stack1;

        private Stack<Integer> stack2;


        public DdfQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void add(int n) {
            stack1.push(n);
        }

        public int poll() {
            if (this.isEmpty()) {
                throw new IllegalStateException("queue is empty");
            }

            if (!stack2.isEmpty()) {
                return stack2.pop();
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            return stack2.pop();
        }

        public int peek() {
            if (this.isEmpty()) {
                throw new IllegalStateException("queue is empty");
            }

            if (!stack2.isEmpty()) {
                return stack2.peek();
            }

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }

            return stack2.peek();
        }

        public boolean isEmpty() {
            return this.size() == 0;
        }

        public int size() {
            return stack2.size() + stack1.size();
        }

    }

    public static void main(String[] args) {
        DdfQueue ddfQueue = new DdfQueue();

        Queue<Integer> queue = new LinkedList<>();

        int times = 500000;

        boolean ok = true;
        for (int i=0; i<times; i++) {
            // 1: add, 2:peek, 3:poll
            int op = -1;

            if (ddfQueue.isEmpty()) {
                op = 1;
            } else {
                op = DUtils.random(1, 3);
            }

            if (op == 1) {
                int el = DUtils.random(Integer.MIN_VALUE, Integer.MAX_VALUE);
                ddfQueue.add(el);
                queue.add(el);

                int size1 = ddfQueue.size();
                int size2 = queue.size();

                if (size1 != size2) {
                    ok = false;
                    System.out.printf("err, size1:%d, size2:%d\n", size1, size2);
                    break;
                }
            } else if (op == 2) {

                int p1 = ddfQueue.peek();
                int p2 = queue.peek();

                if (p1 != p2) {
                    ok = false;
                    System.out.printf("peek err, p1:%d, p2:%d\n", p1, p2);
                    break;
                }
            } else if (op == 3) {
                int p1 = ddfQueue.poll();
                int p2 = queue.poll();

                if (p1 != p2) {
                    ok = false;
                    System.out.printf("poll err, p1:%d, p2:%d\n", p1, p2);
                    break;
                }
            }
        }

        System.out.println(ok ? "ok" : "err...");
    }



}
