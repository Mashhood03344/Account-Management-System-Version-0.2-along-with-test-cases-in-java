import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Savings_AccountTest {

    Savings_Account saving=new Savings_Account("Henry","st 1","123",100,"21/09/2021",0.5);

    @Test
    void checkName(){
        assertEquals("Henry",saving.cust.getName());
    }

    @Test
    void checkAdress(){
        assertEquals("st 1",saving.cust.getAddress());
    }

    @Test
    void checkPhone_number(){
        assertEquals("123",saving.cust.getPhone_Number());
    }

    @Test
    void checkBalance(){
        assertEquals(100,saving.balance);
    }

    @Test
    void checkDate_created(){
        assertEquals("21/09/2021",saving.date_created);
    }

    @Test
    void checkInterest(){
        assertEquals(0.5,saving.interest_rate);
    }
    @Test
    void setInterest_rate() {
        saving.setInterest_rate(0.8);
        assertEquals(0.8,saving.interest_rate);
    }

    @Test
    void setInterest_rateFalse(){
        saving.setInterest_rate(-0.1);
        assertNotSame(-0.1,saving.interest_rate);
    }

    @Test
    void calculatelnterest() {
        saving.calculatelnterest();
        assertEquals(50,saving.calculatelnterest());
    }
}