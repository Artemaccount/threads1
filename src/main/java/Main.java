import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        Callable<Integer> myCallable1 = new MyCallable("Первый колабол");
        Callable<Integer> myCallable2 = new MyCallable("Второй колабол");
        Callable<Integer> myCallable3 = new MyCallable("Третий колабол");
        Callable<Integer> myCallable4 = new MyCallable("Четвертый колабол");


        final ExecutorService threadPool = Executors.newFixedThreadPool(4);
        final Future<Integer> task1 = threadPool.submit(myCallable1);
        final Future<Integer> task2 = threadPool.submit(myCallable2);
        final Future<Integer> task3 = threadPool.submit(myCallable3);
        final Future<Integer> task4 = threadPool.submit(myCallable4);



        System.out.println("Количество сообщений задачи 1: " + task1.get());
        System.out.println("Количество сообщений задачи 2: " + task2.get());
        System.out.println("Количество сообщений задачи 3: " + task3.get());
        System.out.println("Количество сообщений задачи 4: " + task4.get());

        List<Callable<Integer>> list = new ArrayList<>();
        list.add(myCallable1);
        list.add(myCallable2);
        list.add(myCallable3);
        list.add(myCallable4);


        Integer fastest = threadPool.invokeAny(list);
        System.out.println("Самая быстрая: " + fastest);

        threadPool.shutdown();


    }
}
