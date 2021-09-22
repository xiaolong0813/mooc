package ikm;

import java.math.BigDecimal;

public interface account {
    BigDecimal balance = new BigDecimal(0.0);
    String acc = "";

    default void print(){
//        System.out.println("我是一辆车!");
    }

    void method1();
    static void method2(){};
}
