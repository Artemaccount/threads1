import java.util.Random;
import java.util.concurrent.Callable;

class MyCallable implements Callable<Integer> {
    private final String name;

    public MyCallable(String name) {
        this.name = name;
    }

    @Override
    public Integer call() {
        Thread.currentThread().setName(name);
        int max = new Random().nextInt(5);
        Integer i = null;
            for (i = 0; i < max; i++) {
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                } finally {
                    System.out.println(Thread.currentThread().getName() + ": Печатаю сообщение");
                }
            }
        return i;
    }
}