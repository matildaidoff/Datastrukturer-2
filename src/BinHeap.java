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
        int j = set.indexOf(e);
        if(j >= 0 && set.size() > 0) {
            swap(j, set.size() - 1);
            set.remove(set.size() - 1);
            if (set.size() != j) {
                bubbleDown(j);
                bubbleUp(j);
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
            parentIndex = (index-1)/2;
        }
    }
    private void bubbleDown(int index){
        //int index = 0;
            E element = set.get(index);
            int leftChild = index*2 +1;
            int rightChild = index*2 +2;

            if(hasChildL(index) && hasChildR(index)) { //finns 2 barn
                E lChild = set.get(leftChild);
                E rChild = set.get(rightChild);
                if (comp.compare(lChild, rChild ) < 0) { //minsta barnet till vänster
                    if (comp.compare(element, lChild) > 0) { //noden är större än barnet till vänster
                        swap(index, leftChild);
                        bubbleDown(leftChild);
                    }
                }else{
                    if(comp.compare(element, rChild) > 0) { //noden är större än barnet till höger
                        swap(index, rightChild);
                        bubbleDown(rightChild);
                    }
                }
            }else if(hasChildL(index)){ //finns ett barn och det är på vänster
                E lChild = set.get(leftChild);
                if(comp.compare(element, lChild) > 0 ) {
                    swap(index, leftChild);
                    bubbleDown(leftChild);
                }
            }
    }

    private boolean hasParent(int i){
        return i >= 1;
    }
    private boolean hasChildL(int i){
        i = i*2+1;
        return i < set.size();
    }

    private boolean hasChildR(int i){
        i = i*2+2;
        return i < set.size();
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
