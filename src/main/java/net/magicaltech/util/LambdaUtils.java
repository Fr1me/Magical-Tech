package net.magicaltech.util;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaUtils {

    public static <T> boolean forEach(Iterable<T> iterable, Predicate<T> predicate) {
        for (T e : iterable) {
            if (!predicate.test(e)) {
                return false;
            }
        }
        return true;
    }

    public static <E> void forEach(E[] elements, Consumer<E> consumer) {
        for (E element : elements) {
            consumer.accept(element);
        }
    }

}
