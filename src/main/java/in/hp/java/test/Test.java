package in.hp.java.test;

import java.util.Optional;
import java.util.function.Supplier;

public class Test {

    String a;

    public static void main(String[] args) {
        Test t = new Test();
        t.a = null;

        Optional<Object> resolve = t.resolve(() -> t.a);
        System.out.println(resolve.get());

    }

    Optional<Object> resolve(Supplier supplier) {
        return Optional.ofNullable(supplier.get());
    }

    class A {
        String a;
    }


}

