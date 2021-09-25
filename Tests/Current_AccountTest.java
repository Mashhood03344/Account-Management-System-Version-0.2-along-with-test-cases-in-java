import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Current_AccountTest {

    Current_Account current=new Current_Account("Henry","st 1","123",100,"21/09/2021");

    @Test
    void checkName(){
        assertEquals("Henry",current.cust.getName());
    }

    @Test
    void checkAdress(){
        assertEquals("st 1",current.cust.getAddress());
    }

    @Test
    void checkPhone_number(){
        assertEquals("123",current.cust.getPhone_Number());
    }

    @Test
    void checkBalance(){
        assertEquals(100,current.balance);
    }

    @Test
    void checkDate_created(){
        assertEquals("21/09/2021",current.date_created);
    }

    @Test
    void checkTransaction_count(){
        current.makeDeposit(100);
        current.makeWithdrawal(100);

        assertEquals(2,current.transaction_count);
    }

    @Test
    void checkTransaction_fees(){
        current.setBalance(100);
        current.makeDeposit(100);
        current.makeWithdrawal(100);
        current.makeDeposit(100);


        assertEquals(10,current.getTotal_transaction_fees_paid());
    }


}