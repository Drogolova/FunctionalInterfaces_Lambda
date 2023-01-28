import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        System.out.println("Задание 1");
        {
            Predicate<Integer> positive1 = new Predicate<Integer>() {
                @Override
                public boolean test(Integer integer) {
                    return integer > 0;
                }
            };
            System.out.println(positive1.test(5));
        }
        Predicate<Integer> positive2 = x -> (x > 0);
        System.out.println(positive2.test(-1));

        System.out.println("Задание 2");
        {
            Consumer<String> name1 = new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println(s);
                }
            };
            name1.accept("Kate");
        }

        Consumer<String> name2 = t -> System.out.println(t);
        name2.accept("Jack");

        System.out.println("Задание 3");

        {
            Function<Double, Long> longFunction1 = new Function<Double, Long>() {
                @Override
                public Long apply(Double aDouble) {
                    Double bDouble = (double) Math.round(aDouble);
                    return bDouble.longValue();
                }
            };
            System.out.println(longFunction1.apply(8.64821862656));
        }
        Function<Double, Long> longFunction2 = aDouble -> {
            Double bDouble = (double) Math.round(aDouble);
            return bDouble.longValue();
        };
        System.out.println(longFunction2.apply(5.12648586));

        System.out.println("Задание 4");
        {
            Supplier random1 = new Supplier() {
                @Override
                public Object get() {
                    double random = Math.random() * 100;
                    return Math.round(random);
                }
            };
            System.out.println(random1.get());
        }
        Supplier random2 = () -> {
            double random = Math.random() * 100;
            return Math.round(random);
        };
        System.out.println(random2.get());

        System.out.println("Задание 5");
        Predicate<Integer> p = x -> (x > 0);
        Function<Integer, Integer> f1 = x -> 0;
        Function<Integer, Integer> f2 = x -> x;
        Function<Integer, Integer> t = ternaryOperator(p, f1, f2);
        System.out.println(t.apply(5));
        System.out.println(t.apply(-5));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return a -> (condition.test(a) ? ifTrue.apply(a) : ifFalse.apply(a));
    }

    public static <T> void log(T x) {
        System.out.println(x);
    }
}