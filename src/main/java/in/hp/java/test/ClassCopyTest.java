package in.hp.java.test;

import java.util.ArrayList;
import java.util.List;

public class ClassCopyTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(200);
        list.add(100);

        System.out.println(list.stream().reduce(0, Integer::sum));
    }
}

class A {
    int a;
    B b;
}

class B {

}