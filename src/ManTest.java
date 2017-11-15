import java.util.Comparator;

public class ManTest {
    public static void main(String[] args) {
        PrioQueue<Integer> pq = new BinHeap<>(new NaturalOrderComparator<Integer>());
        pq.add(1);
        pq.iterator();
        pq.add(1);
        //pq.add(12);
        pq.poll();
        pq.remove(5);
        //pq.remove(1);
        //System.out.println(pq.peek());
        //System.out.println(pq.poll());
        System.out.println(pq.toString());
    }

}
