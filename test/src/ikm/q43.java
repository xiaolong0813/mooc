package ikm;

public class q43 {

    class Foo {
        native int bar(String S);
        {
            System.loadLibrary("foo_bar");
        }}


}
