import java.util.Iterator;

public class StockTrade {
    private PrioQueue<Bid> sellersQueue;
    private PrioQueue<Bid> buyersQueue;

    public StockTrade() {
        sellersQueue = new BinHeap<Bid>(new Sellcomp());
        buyersQueue = new BinHeap<Bid>(new Buycomp());

    }

    public Transaction placeSellBid(Bid bid) {


    }

    public Transaction placeBuyBid(Bid bid) {

    }

    public Iterator<Bid> sellBidsIterator() {
        return sellersQueue.iterator();
    }

    public Iterator<Bid> buyBidsIterator() {
        return buyersQueue.iterator();
    }
}