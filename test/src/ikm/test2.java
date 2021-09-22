package ikm;

public class test2 {

//    public class Invoice {
//        public String formatId(String oldId) {
//            return oldId + "Invoice";
//        }
//    }
//    public class SalesInvoice extends Invoice {
//        public String formatId (String oldId) {
//            return oldId + "_SalesInvoice";
//        }
//    }

    public static void main(String[] args) {

        Invoice invoice = new Invoice();
        System.out.println(invoice.formatId("1234"));

        SalesInvoice invoice1 = new SalesInvoice();
        System.out.println(invoice1.formatId("1234"));

    }
}
