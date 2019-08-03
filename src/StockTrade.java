import java.util.Iterator;

public class StockTrade {
    private PrioQueue<Bid> sellersQueue;
    private PrioQueue<Bid> buyersQueue;

    public StockTrade() {
        sellersQueue = new BinHeap<Bid>(new Sellcomp());
        buyersQueue = new BinHeap<Bid>(new Buycomp());

    }

    public Transaction placeSellBid(Bid bid) {

            for(Bid b: sellersQueue) {
                if (b.name.equals(bid.name)) {
                    sellersQueue.remove(b);
                    break;
                }
            }
            sellersQueue.add(bid);
            if(buyersQueue.peek() != null && sellersQueue.peek().price <= buyersQueue.peek().price)
                //sellersQueue.poll().name;
                return new Transaction(sellersQueue.poll().name, buyersQueue.peek().name, buyersQueue.poll().price);


        return null;
    }

    public Transaction placeBuyBid(Bid bid) {
        for(Bid b: buyersQueue) {
            if (b.name.equals(bid.name)) {
                buyersQueue.remove(b);
                break;
            }
        }
        buyersQueue.add(bid);
        if(sellersQueue.peek() != null && sellersQueue.peek().price <= buyersQueue.peek().price)
                return new Transaction(sellersQueue.poll().name, buyersQueue.peek().name, buyersQueue.poll().price);

        return null;
    }

    public Iterator<Bid> sellBidsIterator() {
        return sellersQueue.iterator();
    }

    public Iterator<Bid> buyBidsIterator() {
        return buyersQueue.iterator();
    }
}