package function;

/**
 *
 */
@FunctionalInterface
public interface TriConsumerEx<T,U, R> {
    void accept(T t, U u, R r) throws Exception;
}
