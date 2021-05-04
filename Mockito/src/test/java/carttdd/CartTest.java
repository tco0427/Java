package carttdd;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartTest {
    @Test
    public void testTotalNumberOfItemsIncart(){
        Cart cart=new Cart();
        cart.put("1234");
        cart.put("1234");
        cart.put("3456");
        cart.put("3456");
        cart.put("3456");
        cart.put("7891");
        int totalNum1=cart.getTotalNumberOfItemsInCart("1234");
        assertEquals(2,totalNum1);
        int totalNum2=cart.getTotalNumberOfItemsInCart("3456");
        assertEquals(3,totalNum2);
        int totalNum3=cart.getTotalNumberOfItemsInCart("7891");
        assertEquals(1,totalNum3);
    }

    @Mock
    PriceManager pm;
    @InjectMocks
    Cart cart;
    @Test
    public void testTotalPrice(){
        MockitoAnnotations.initMocks(this);
        when(pm.getPrice("1234")).thenReturn(1000);
        when(pm.getPrice("7891")).thenReturn(800);
        when(pm.getPrice("3456")).thenReturn(2500);
        when(pm.isOnePlusOneApplicable("1234")).thenReturn(false);
        when(pm.isOnePlusOneApplicable("7891")).thenReturn(false);
        when(pm.isOnePlusOneApplicable("3456")).thenReturn(true);
        cart.put("1234");
        int total=cart.totalPrice();
        assertEquals(1000,total);
        cart.put("7891");
        total=cart.totalPrice();
        assertEquals(1800,total);
        cart.put("3456");
        cart.put("3456");
        total=cart.totalPrice();
        assertEquals(4300,total);
    }
}
