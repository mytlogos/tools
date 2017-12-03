package tools;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

/**
 *
 */
public class Condition {
    private static final Condition instance = new Condition();

    private Condition() {
        if (instance != null) {
            throw new IllegalStateException();
        }
    }

    public static Condition check() {
        return instance;
    }

    public Condition greaterEqualThan(int i, int... ints) {
        if (Arrays.stream(ints).anyMatch(value -> value < i)) {
            throw new IllegalArgumentException("a value is smallern than " + i);
        }
        return this;
    }

    public Condition greaterEqualThan(long i, long... longs) {
        if (Arrays.stream(longs).anyMatch(value -> value < i)) {
            throw new IllegalArgumentException("a value is smallern than " + i);
        }
        return this;
    }
    public Condition greaterEqualThan(double i, double... doubles) {
        if (Arrays.stream(doubles).anyMatch(value -> value < i)) {
            throw new IllegalArgumentException("a value is smallern than " + i);
        }
        return this;
    }

    public Condition nonNull(Object... objects) {
        Object[] array = Arrays.stream(objects).filter(Objects::isNull).toArray();

        if (array.length != 0) {
            StringBuilder builder = new StringBuilder("Following are null when not allowed: ");

            for (int i = 0, objectsLength = array.length; i < objectsLength; i++) {
                Object object = array[i];
                builder.append(object);

                if (i - 1 < objectsLength) {
                    builder.append(", ");
                }
            }
            throw new IllegalArgumentException(builder.toString());
        }
        return this;
    }

    public Condition notEmpty(String... strings) {
        Object[] objects = Arrays.stream(strings).filter(String::isEmpty).toArray();

        if (objects.length != 0) {
            StringBuilder builder = new StringBuilder("Following are empty when not allowed: ");

            for (int i = 0, objectsLength = objects.length; i < objectsLength; i++) {
                Object object = objects[i];
                builder.append(object.getClass().getSimpleName());

                if (i - 1 < objectsLength) {
                    builder.append(", ");
                }
            }
            throw new IllegalArgumentException(builder.toString());
        }
        return this;
    }
    public Condition notEmpty(Collection<?>... collections) {
        Object[] objects = Arrays.stream(collections).filter(Collection::isEmpty).toArray();
        if (objects.length != 0) {
            StringBuilder builder = new StringBuilder("Following are empty when not allowed: ");
            for (int i = 0, objectsLength = objects.length; i < objectsLength; i++) {
                Object object = objects[i];
                builder.append(object.getClass().getSimpleName());

                if (i - 1 < objectsLength) {
                    builder.append(", ");
                }
            }
            throw new IllegalArgumentException(builder.toString());
        }
        return this;
    }

    public Condition positive(int... ints) {
        greaterEqualThan(0, ints);
        return this;
    }

    public Condition positive(long... longs) {
        greaterEqualThan(0, longs);
        return this;
    }

    public Condition positive(double... doubles) {
        greaterEqualThan(0, doubles);
        return this;
    }
}
