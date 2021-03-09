package books;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class BookShopTest {

    private BookShop bookshop;

    @BeforeEach
    public void init() {
        this.bookshop = new BookShop("Harry Potter");
    }

    @Test
    @DisplayName("Test test")
    public void myFirstTest(){
        assertTrue(true);
    }

    @Test
    @DisplayName("Buy 1 Different Book")
    public void buy1DifferentBook() {
        double price = 8;
        int[] books1 = {1,0,0,0,0};
        int[] books2 = {0,1,0,0,0};
        int[] books3 = {0,0,1,0,0};
        int[] books4 = {0,0,0,1,0};
        int[] books5 = {0,0,0,0,1};
        assertEquals(price, bookshop.cost(books1), "Should equal 8");
        assertEquals(price, bookshop.cost(books2), "Should equal 8");
        assertEquals(price, bookshop.cost(books3), "Should equal 8");
        assertEquals(price, bookshop.cost(books4), "Should equal 8");
        assertEquals(price, bookshop.cost(books5), "Should equal 8");
    }

    @Test
    @DisplayName("Buy 2 Different Books")
    public void buy2DifferentBooks() {
        double price = 2*8*(1-0.07);
        int[] books1 = {0,1,1,0,0};
        int[] books2 = {1,0,0,0,1};
        assertEquals(price, bookshop.cost(books1), "Should equal " + price);
        assertEquals(price, bookshop.cost(books2), "Should equal " + price);
    }

    @Test
    @DisplayName("Buy 3 Different Books")
    public void buy3DifferentBooks() {
        double price = 3*8*(1-0.14);
        int[] books1 = {1,1,0,1,0};
        int[] books2 = {1,0,0,1,1};
        assertEquals(price, bookshop.cost(books1), "Should equal " + price);
        assertEquals(price, bookshop.cost(books2), "Should equal " + price);
    }

    @Test
    @DisplayName("Buy 4 Different Books")
    public void buy4DifferentBooks() {
        double price = 4*8*(1-0.28);
        int[] books1 = {1,1,0,1,1};
        int[] books2 = {0,1,1,1,1};
        assertEquals(price, bookshop.cost(books1), "Should equal " + price);
        assertEquals(price, bookshop.cost(books2), "Should equal " + price);
    }

    @Test
    @DisplayName("Buy 5 Different Books")
    public void buy5DifferentBooks() {
        double price = 5*8*(1-0.35);
        int[] books1 = {1,1,1,1,1};
        assertEquals(price, bookshop.cost(books1), "Should equal " + price);
    }

    @Test
    @DisplayName("Buy 2 times the same books")
    public void buy2SameBooks() {
        double price = 8 + 8;
        int[] books1 = {0,0,2,0,0};
        assertEquals(price, bookshop.cost(books1), "Should equal " + price);
    }

    @Test
    @DisplayName("Buy 4 books, 1 duplicate books")
    public void buy4Books1Duplicate() {
        double price = 3*8*(1-0.14) + 8;
        int[] books1 = {0,1,2,0,1};
        assertEquals(price, bookshop.cost(books1), "Should equal " + price);
    }

    @Test
    @DisplayName("Buy 9 Books, 4 duplicates")
    public void buy9Books4Duplicates() {
        double price = 5*8*(1-0.35) + 4*8*(1-0.28);
        int[] books1 = {1,2,2,2,2};
        assertEquals(price, bookshop.cost(books1), "Should equal " + price);
    }

    @Test
    @DisplayName("Buy 6 books, 1 duplicate, 1 triplet books")
    public void buy6Books1Duplicate1Triplet() {
        double price = 3*8*(1-0.14) + 2*8*(1-0.07) + 8;
        int[] books1 = {0,1,3,0,2};
        assertEquals(price, bookshop.cost(books1), "Should equal " + price);
    }

}
