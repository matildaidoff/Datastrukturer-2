import java.util.*;

public class BinHeap <E>implements PrioQueue<E> {
    private Comparator<? super E> comp;
    private ArrayList<E> set = new ArrayList<E>();

    public BinHeap(Comparator<? super E> comp) {
        set = new ArrayList<E>();
        this.comp = comp;
    }
    public void add(E e) {
        int index = set.size();
        set.add(index, e);
        bubbleUp();
    }

    public E poll(){
        if(set.size() > 0) {
            E high = peek();
            remove(high);
            return high;
        }return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public void remove(E e) {
        for (int i = 0; i < set.size(); i++)
            if(e.equals(set.get(i)))
                set.remove(e);

    }

    @Override
    public E peek() {
        if(set.get(0) == null)
            return null;

        return set.get(0);
    }

    private void bubbleUp(){
        int index = set.size()-1;
        int parentIndex = (index-1)/2;
        while (hasParent(index) && comp.compare(set.get(index), set.get(parentIndex)) <= 0){
            swap(parentIndex, index);
            index = parentIndex;
        }
    }
    private void bubbleDown(){

    }

    private boolean hasParent(int i){
        return i > 1;
    }

    private void swap(int i1, int i2){
        E temp = set.get(i2);
        set.set(i2, set.get(i1));
        set.set(i1, temp);
    }

    @Override
    public String toString() {
        return "BinHeap{" +
                "set=" + set +
                '}';
    }

    /*@Override
    public void remove() {
        throw new UnsupportedOperationException();
    }*/
}
