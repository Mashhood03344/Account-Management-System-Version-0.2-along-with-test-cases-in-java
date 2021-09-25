import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountsTest {

    Accounts account=new Accounts("Henry","St 1","123",100,"21/09/2021");

    @Test
    void checkBalance() {
        assertEquals("Henry",account.cust.getName());
        assertEquals(100,account.balance);

    }

    @Test
    void makeDeposit() {
        account.makeDeposit(50);
        assertEquals(150,account.balance);
    }

    @Test
    void makeDepositFalse(){
        account.makeDeposit(-1);
        assertNotSame(99,account.balance);
    }



    @Test
    void makeWithdrawal() {
        account.setBalance(100);
        account.makeWithdrawal(100);
        assertEquals(0,account.balance);
    }

    @Test
    void makeWithdrawlExceed(){
        account.makeWithdrawal(150);

        assertNotSame(0,account.balance);
    }


    @Test
    void makeWithdralFalse(){
        account.makeWithdrawal(-10);
        assertNotSame(90,account.balance);
    }

    @Test
    void calculateZakat() {
        assertEquals(2.5,account.calculateZakat());
    }

    @Test
    void setBalance() {
        account.setBalance(150);
        assertEquals(150,account.balance);
    }

    @Test
    void setBalanceFalse(){
        account.setBalance(-90);
        assertNotSame(60,account.balance);
    }

    @Test
    void setDate_created() {
        account.setDate_created("21/08/2021");
        assertEquals("21/08/2021",account.date_created);
    }

    @Test
    void setDate_createdFalse(){
      account.setDate_created("");
      assertNotSame("21/08/2021",account.date_created);
    }

    @Test

    void CheckTransactionCount(){
        account.makeWithdrawal(10);
        account.makeDeposit(10);

        assertEquals(2,account.transaction_count);
    }
}