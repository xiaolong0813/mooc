package ikm;

public class Call_Parent_Child {
    public void writeStr() {
        Child parent = new Child();
//        System.out.println(parent.buildStr("O, "));
    }

    public static void main(String[] args) {
        new Call_Parent_Child().writeStr();
    }
}
