import java.util.Comparator;

public class ManTest {
    public static void main(String[] args) {
        PrioQueue<Integer> pq = new BinHeap<>(new NaturalOrderComparator<Integer>());
        pq.add(3);
        pq.add(9);
        pq.add(1);
        pq.add(2);
        pq.add(5);
        pq.remove(6);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.toString());
    }

}
