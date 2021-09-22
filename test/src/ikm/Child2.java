package ikm;

public class Child2 extends Parent{
    public void retValue() {
        System.out.println("LB_2");
    }

//    @Override
//    public String buildStr(String cur) {
//        return "";
//    }

//    @Override
//    protected String buildStr(String cur) throws Exception{
//        return "";
//    }

    public static void main(String args[]) {
        Child2 lb = new Child2();
        lb.retValue();
        System.out.println(lb.pname);
    }
}
