import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class testMain {

    public class MyCollection<T> {
        private Set<T> set;
        public Set<T> getCollection(){
            return this.set;
        }
//        public void TestCollection(MyCollection<?> collection){
//            Set<T> set = collection.getCollection();
//        }
    }
    public void meth(String[] arg){
        System.out.println(arg);
        System.out.println(arg[1]);
    }

    public class vv implements Spliterator{

        @Override
        public boolean tryAdvance(Consumer action) {
            return false;
        }

        @Override
        public Spliterator trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return 0;
        }

        @Override
        public int characteristics() {
            return 0;
        }
    }

    protected class Tes{
        String haha = "345";

    }


    public static void openacc(String accnum){
//        Tes t = new Tes();
//        System.out.println(t.haha);



    }

    public enum report{
        EMPRPT(1,"Emp_report"), MNGRPT(2, "mana_report");

        private String name;
        private int id;

        report(int i, String name) {
            this.setName(name);
            this.id =id;
        }
        public String getName (){return name;}

        public int getId (){return id;}


        private void setName(String name) {
            this.name =name;
        }
    }



    public class my{

//        private static final my ins =new my();
//        private

//        private my ins = new my();
//        public my getIns(){return ins}
//        private synchronized static my getInstance(){
//            return new my();
//        }
    }

// class B extends Arrays{
//
//        @Override
//
//
// }

//    public void row() throws IOException {
//
//        Path in = Paths.get("t.txt");
//        Path o = Paths.get("2t.txt");
//
//        BufferedReader reader = Files.newBufferedReader(in, Charset.defaultCharset());
//        BufferedReader wr = Files.newBufferedReader(o, Charset.defaultCharset());
//
//
//    }



    public static void main(String[] args) throws InterruptedException, IOException {

//        String rep=args[0];
//        System.out.println(rep.equals(report.EMPRPT.getName()));
//        System.out.println(rep.equals(report.EMPRPT));
//        System.out.println(rep.equals(report.MNGRPT.toString()));
//        System.out.println(rep.equals(report.MNGRPT.name()));

//        Stream

//        Path input = Paths.get("data.txt").toString();







//        byte c1[] = {10,20,30,40,50};
//        byte c2[]={60,70,80,90};
//
//        ByteArrayOutputStream b1 = new ByteArrayOutputStream();
//        ByteArrayOutputStream b2 = new ByteArrayOutputStream(10);
//        b2.write(100);
//
//        System.out.println("out1"+b2.size());
//
//        b2.write(c1,0,c2.length);
//        System.out.println("out2"+b2.size());
//
//        byte b[]=b2.toByteArray();
//        System.out.println("out3"+b.length);
//
//        b2.flush();
//        System.out.println("out4"+b2.size());
//
//        b2.reset();
//        System.out.println("out5"+b2.size());
//
//        b1.writeTo(b2);
//        System.out.println("out6"+b1.size());



//        LocalDate d = LocalDate.of(2000)
//        GregorianCalendar gc = new GregorianCalendar();

//        Calendar ca = Calendar.getInstance();
//        ca.set(Calendar.YEAR,2000);
//
//        System.out.println(ca.getMaximum(Calendar.DAY_OF_YEAR)>365);


//        Thread req = new Thread();
//        req.start();
//
//        System.out.println("handle req1");
//
//        req.wait(10000);
//        System.out.println("handle req2");





//        int x =-1;
//        System.out.println(x=x>>>32);



//        File file =new File("data.txt");
//        FileWriter out = new FileWriter(file);
//
////        out.write(new char[]{'0','1','2','0',});
//
////        PrintWriter p = new PrintWriter(out);
////        Stream.of('0','1','3').forEach(out::write);
////        for (int i=0;i<5;i++){
////            out.write(String.valueOf(i));
////        }
//        out.flush();


//        Math.sin

//        Long i =new Long(10);
//        long j =10;
//        long k=-5;
//        if (i.equals(j))
//            System.out.println("i=j");
//        else
//            System.out.println("i!=j");
//        if (Long.compare(i,k)>0)
//            System.out.println("i>k");
//        else
//            System.out.println("i<k");
//        if (Long.compareUnsigned(i,k)>0)
//            System.out.println("i>k");
//        else
//            System.out.println("i<k");
//        StringBuilder str = new StringBuilder();
//        for (String arg:args){
//            if (str.indexOf(arg)<1)
//                str.append(arg+" ");
//        }
//        System.out.println(str.toString());
//        Scanner sc = new Scanner(str.toString());
//        while (sc.hasNext()){
//            if (sc.hasNextInt())
//                System.out.println(sc.nextInt()+" ");
//            else
//                sc.next();
//        }
//        meth(args);

//        String a =null;
//        Optional<String> b =Optional.empty();
//        try {
//            System.out.println(a.length());
//            System.out.println(b.orElse("").length());
//        }catch (Exception e){
//            System.out.println(a);
//        }
//        finally {
//            a="String";
//            System.out.println(a.length());
//            b=Optional.ofNullable("");
//            System.out.println(b.get().length());
//        }
//        Integer x =3;
//        Integer y=null;
//        try {
//            System.out.println(Integer.compareUnsigned(x,3)==0||Integer.compareUnsigned(y,0)==0);
//
//        }catch (Exception e){
//            System.out.println(e.getClass().toString());
//        }
//        try {
//            System.out.println(y.compareTo(null)==0||true);
//        }catch (Exception e){
//            System.out.println(e.getClass().toString());
//        }


//        RandomAccessFile r = new RandomAccessFile();

//        BlockingQueue



//        Locale param1 = Locale.ENGLISH;
//        String param2 = "UTF-16";
//
//        Map<String, Integer> names = Calendar.getInstance().getDisplayNames(Calendar.DAY_OF_WEEK, Calendar.LONG, param1);
//        System.out.println(names.toString());
//        try{
//            File file = new File("test1.txt");
//            FileOutputStream fos= new FileOutputStream(file);
//            Writer out = new OutputStreamWriter(fos, param2);
//            out.write(names.toString());
//            out.close();
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }
}
