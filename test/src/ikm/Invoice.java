package ikm;

import jdk.nashorn.internal.ir.annotations.Immutable;

public class Invoice {

    public static String formatId(String oldId) {
        return oldId + "_Invoice";
    }

}
