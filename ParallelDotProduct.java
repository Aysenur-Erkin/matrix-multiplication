import java.util.Scanner;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class DotProductTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 1000;
    private int[] vector1;
    private int[] vector2;
    private int start;
    private int end;

    public DotProductTask(int[] vector1, int[] vector2, int start, int end) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += vector1[i] * vector2[i];
            }
            return sum;
        } else {
            int mid = (start + end) / 2;
            DotProductTask leftTask = new DotProductTask(vector1, vector2, start, mid);
            DotProductTask rightTask = new DotProductTask(vector1, vector2, mid, end);

            leftTask.fork();
            int rightResult = rightTask.compute();
            int leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }
}

public class ParallelDotProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Vektorlerin boyutunu girin: ");
        int size = scanner.nextInt();

        int[] vector1 = new int[size];
        int[] vector2 = new int[size];

        
        System.out.println("Birinci vektorun elemanlarini girin:");
        for (int i = 0; i < size; i++) {
            vector1[i] = scanner.nextInt();
        }

       
        System.out.println("Ikinci vektorun elemanlarini girin:");
        for (int i = 0; i < size; i++) {
            vector2[i] = scanner.nextInt();
        }

        ForkJoinPool pool = new ForkJoinPool();
        DotProductTask task = new DotProductTask(vector1, vector2, 0, size);

        int result = pool.invoke(task);
        System.out.println("Vektorlerin ic carpimi: " + result);

        scanner.close();
    }
}


