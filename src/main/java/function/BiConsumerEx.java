package function;

/**
 *
 */
@FunctionalInterface
public interface BiConsumerEx<T, U> {
    void accept(T t, U u) throws Exception;
}
