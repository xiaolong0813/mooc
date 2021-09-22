package ikm;

public class Superclass {

    Superclass() {
//        this(0);
        System.out.println("super 0 para");
        System.out.println("1");
    }

    Superclass(int x) {
        System.out.println("super with para");
        System.out.println("2"+x);
    }
}
class Subclass extends Superclass {
    Subclass(int x) {
        System.out.println("sub one para");
        System.out.println("3"+ x);
    }
    Subclass(int x, int y) {
        this(x);
        System.out.println("sub two para");
        System.out.println("4"+ x + y);
    }
    public static void main(String[] args) {
        new Subclass(2, 3);
    }
}

