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
        bubbleUp(index);
    }

    public E poll(){
        if(set.size() > 0) {
            E high = peek();
            remove(high);
            return high;
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return set.iterator();
    }

    @Override
    public void remove(E e) {
        if(set.contains(e)) {
            for (int i = 0; i < set.size(); i++) {
                if (e.equals(set.get(i))) {
                    swap(i, set.size()-1);
                    set.remove(set.size()-1);
                    bubbleDown(i);
                    break;
                }
            }

        }
    }

    @Override
    public E peek() {
        if(set.size() == 0)
            return null;

        return set.get(0);
    }

    private void bubbleUp(int index){
        //int index = set.size()-1;
        int parentIndex = (index-1)/2;
        while (hasParent(index) && comp.compare(set.get(index), set.get(parentIndex)) < 0){
            swap(parentIndex, index);
            index = parentIndex;
        }
    }
    private void bubbleDown(int index){
        //int index = 0;
        while(hasChildL(index)){
            int smallerChild = index*2+1;
            if(hasChildH(index) && comp.compare(set.get(index), set.get(smallerChild)) < 0)
                smallerChild = index*2+2;
            if (comp.compare(set.get(index), set.get(smallerChild)) > 0)
                swap(index, smallerChild);
            else
                break;

            index = smallerChild;
        }

    }

    private boolean hasParent(int i){
        return i >= 1;
    }
    private boolean hasChildL(int i){
        i = i*2+1;
        return i <= set.size();
    }

    private boolean hasChildH(int i){
        i = i*2+2;
        return i <= set.size();
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
