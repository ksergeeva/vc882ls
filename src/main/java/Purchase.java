import java.util.Map;

public class Purchase {
    public static class Purs2 {
        protected String title;
        protected int count;

        public Purs2(String title, int count) {
            this.title = title;
            this.count = count;
        }
    }

    protected Purs2[] purchases;

    public Purchase(int size) {
        purchases = new Purs2[size];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purs2(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (Purs2 purchase : purchases) {
            if (purchase == null) {
                continue;
            }
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + (purchase.count * prices.get(purchase.title)) + " руб.");
            sum += (long) purchase.count * prices.get(purchase.title);
        }
        return sum;
    }
}