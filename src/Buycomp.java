import java.util.Comparator;


public class Buycomp implements Comparator<Bid>  {

    public Buycomp(){
    }

    @Override
    public int compare(Bid o1, Bid o2) {
        return o2.price - o1.price;
    }
}
