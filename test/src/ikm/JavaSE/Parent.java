package ikm.JavaSE;

public class Parent {

    public String pname = "father";
    protected String buildStr(String cur) {
        return cur + "1";
    }

    public void retValue() {
        System.out.println("LB_1");
    }
}