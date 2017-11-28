import java.util.Comparator;


public class Sellcomp implements Comparator<Bid>  {

    public Sellcomp(){
    }

    @Override
    public int compare(Bid o1, Bid o2) {
        return o2.price - o1.price;
    }
}
