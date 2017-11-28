import java.util.Comparator;

public class ManTest {
    public static void main(String[] args) {
        PrioQueue<Integer> pq = new BinHeap<>(new NaturalOrderComparator<Integer>());
        pq.remove(5);
        pq.add(6);
        pq.add(6);
        pq.add(2);
        pq.remove(1);
        pq.add(1);
        System.out.println(pq.toString());
        pq.poll();
        System.out.println(pq.toString());
    }

}
