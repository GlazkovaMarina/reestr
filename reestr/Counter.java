package reestr;

public class Counter implements AutoCloseable {
    static int count;
    {
        count = 0;
    }

    public void add() {
        ++count;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Counter closed");
    }

    public static int getCount() {
        return count;
    }

}
