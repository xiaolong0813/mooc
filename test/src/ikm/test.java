package ikm;

import java.io.DataInput;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class test {
    public static void main(String[] args) {

        Date aDate= null;
        try {
            aDate = new SimpleDateFormat("yyyy-mm-dd").parse("2012-01-15");
            Calendar aCalendar = Calendar.getInstance();
            aCalendar.setTime(aDate);
            System.out.print(aCalendar.get(aCalendar.DAY_OF_MONTH)+","+aCalendar.get(aCalendar.MONTH));
        } catch (ParseException e) {
            System.out.println(e);
    }

//        OutputStream outputStream = new OutputStream() {
//            @Override
//            public void write(int b) throws IOException {
//
//            }
//        }
//        DataInput d = new DataInput() {
//        }
//        Queue<Integer> queue = new Queue<Integer>() {
//        }
//        ArrayList<String> arrayList = new ArrayList();

//        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
//        priorityQueue.add(1);
//        priorityQueue.add(2);
//        System.out.println(priorityQueue.element());



//        int x = 5, y = 0;
//        try {
//            try {
//                try {
//                    System.out.println(x);
//                    System.out.println(x / y);
//                    System.out.println(y);
//                } catch (ArithmeticException ex) {
//                    System.out.println("Ïnner Catch1");
//                    throw ex;
//                }
//            } catch (RuntimeException ex) {
//                System.out.println("Ïnner Catch2");
//                throw ex;
//            }
//            finally {
//                System.out.println("Inner Finally");
//            }
//        } catch(Exception ex)
//        {
//            System.out.println("Outer Catch");
//        }

    }

    }

