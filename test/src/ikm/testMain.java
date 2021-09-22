package ikm;

import java.io.BufferedReader;
import java.math.BigDecimal;
import java.security.PublicKey;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class testMain {


    public class subTest {
        String sub = "";

    }

    public Integer getN() {
        return 2;
    }

    public void setn(Integer n) {

    }

    static class help{
        private int data =5;
        public void bump(int i) {
            i++;
            data = data +i;
        }
    }


    public static void main(String[] args) throws NoSuchMethodException {

        Locale locale = new Locale.Builder().setLanguage("en").setRegion("GB").build();
        System.out.println(locale.getClass());

//        help h = new help();
//        int d = 2;
//        h.bump(d);
//        System.out.println(h.data+" "+d);
//        savingaccount instance= new savingaccount(new BigDecimal(50.00)); System.out.println(instance);

//        Supplier<String> i = () -> "Car";
//        Consumer<String> c = x -> System.out.println(x.toLowerCase());
//        Consumer<String> d = x -> System.out.println(x.toUpperCase());
//        c.andThen(d).accept(i.get());
//        System.out.println();

//        System.out.println(Runtime.getRuntime().);

//        System.out.println(new testMain().getClass().getMethod("getN",null).toString());
//        System.out.println(new testMain().getClass().getDeclaredMethod("setn",null).toString());

//        Stream.of([1,2,3,4,5,6,7],[1,2,3,4,5])

//        int b = 0;
//        System.out.println((0==b++)?"true":"false");
////        BufferedReader b = new BufferedReader()
//        YearMonth y1 = YearMonth.of(2015,Month.SEPTEMBER);
//        YearMonth y2 = YearMonth.of(2016, Month.FEBRUARY);
//
//        System.out.println(y2.until(y1, ChronoUnit.MONTHS));
//        System.out.println(y1.minus(Period.ofMonths(4)).getMonthValue());
//        System.out.println(y2.compareTo(y1));
//        int x =6;
//        testMain t = new testMain();
//        System.out.println(t.x);

//        String a = "first";
//        String b = new String("first");
//        "first".concat("second");
//        System.out.println(a.equals(b));
//        System.out.println(a == b);
//        System.out.println(a.equals("firstsecond"));
//        System.out.println(b == "first");
    }
}


