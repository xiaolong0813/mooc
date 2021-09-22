package ikm;

import java.math.BigDecimal;

abstract class savingaccount implements account {

    public abstract void method1();
//    public savingaccount(BigDecimal intialValue){
////        balance = intialValue;
////        acc = "ppp";
//    }
    public String toString(){
        return balance.toString();
    }
//
//    @Override
//    public void testFunc() {
//
//    }
}

//public abstract class Child extends Parent implements account {
//    public void method1() {
//
//    }
////    public static void method2();
//}
