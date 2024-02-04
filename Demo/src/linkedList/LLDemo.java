package linkedList;

public class LLDemo {
    private int head;
    private int tail;

    public static void main(String[] args) {
        LLDemo ex = new LLDemo();
        ex.bar();
    }

    public void bar() {
        tail = 5;
        System.out.println("Inside bar t" + tail);
        foo();
    }

    private void foo() {
        head=tail;
        System.out.println("Inside foo t" + tail);
        System.out.println("Inside foo h" + tail);
    }
}
