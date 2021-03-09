package books;

import java.util.stream.IntStream;

public class BookShop {

    private final String name;
    private final double price;

    /**
     * Constructor of the class Book shop
     * @param name name of the book shop
     */
    public BookShop(String name){
        this.name = name;
        this.price = 8;
    }

    /**
     * method to compute the cost of a basket
     * @param books array corresponding to the number of each harry potter book the client desire to buy (books.length should return 5)
     * @return the cost in euro with the discount
     */
    public double cost(int[] books){
        double cost = 0.0;
        int uniqBooksCnt;
        while (IntStream.of(books).sum() > 0) {

            uniqBooksCnt = 0;
            for (int i=0; i < books.length; i++) {
                if (books[i] > 0) {
                    ++uniqBooksCnt;
                    --books[i];
                }
            }

            switch (uniqBooksCnt) {
                case 1: cost = cost + this.price;
                        break;
                case 2: cost = cost + 2 * this.price * (1 - 0.07);
                        break;
                case 3: cost = cost + 3 * this.price * (1 - 0.14);
                        break;
                case 4: cost = cost + 4 * this.price * (1 - 0.28);
                        break;
                case 5: cost = cost + 5 * this.price * (1 - 0.35);
                        break;
                //something must've gone wrong if none of the avbove were triggered
                default: return -1.0;
            }

        }
        return cost;
    }
}
