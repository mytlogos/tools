package function;

/**
 *
 */
@FunctionalInterface
public interface ConsumerEx<E> {
    void consume(E e) throws Exception;
}
