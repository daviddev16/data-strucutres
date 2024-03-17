package com.daviddev16;

import java.util.Objects;
import java.util.StringJoiner;

public final class Util {

    public static String internalToPrettyString(boolean mostrarElementosNulos, Object[] array) {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (Object object : array) {
            if (mostrarElementosNulos || object != null)
                stringJoiner.add(Objects.toString(object, "?"));
        }
        return "[" + stringJoiner.toString() + "]";
    }

}
