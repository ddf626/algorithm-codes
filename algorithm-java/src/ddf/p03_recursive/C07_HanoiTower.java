package ddf.p03_recursive;

public class C07_HanoiTower {

    /**
     * n个盘子 从 from 接触 borrow 放到to
     */
    public static void process(int n, char from, char to, char borrow) {
       if (n == 1) {
           System.out.printf("Move %c -> %c\n", from, to);
           return;
       }

       process(n-1, from, borrow, to);

       System.out.printf("Move %c -> %c\n", from, to);

       process(n-1, borrow, to, from);
    }

    public static void main(String[] args) {
        process(3, 'a', 'b', 'c');
    }

}
