import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {
    LocalDate d=LocalDate.now();
    LocalTime t=LocalTime.now();
    Transaction transect=new Transaction(20,d,t,'d');
    @Test
    void setTransaction_amount() {
        transect.setTransaction_amount(30);
        assertEquals(30,transect.getTransaction_amount());
    }

    @Test
    void setTransact_amountFalse(){
        transect.setTransaction_amount(-1);
        assertNotSame(-1,transect.getTransaction_amount());
    }

    @Test
    void setCurr_date() {

        LocalDate date=LocalDate.now();
        transect.setCurr_date(date);
        assertEquals(date,transect.getDate_of_transaction());
    }

    @Test
    void setCurr_time() {
        LocalTime time=LocalTime.now();
        transect.setCurr_time(time);
        assertEquals(time,transect.getTime_of_transaction());
    }

    @Test
    void setTransaction_type() {
        transect.setTransaction_type('w');
        assertEquals('w',transect.getTransaction_type());
    }

    @Test
    void setTransaction_typeFalse(){
        transect.setTransaction_type('s');
        assertNotEquals('s',transect.getTransaction_type());
    }
    @Test
    void getTransaction_amount() {
        assertEquals(20,transect.getTransaction_amount());
    }

    @Test
    void getDate_of_transaction() {
        assertEquals(d,transect.getDate_of_transaction());
    }

    @Test
    void getTime_of_transaction() {
        assertEquals(t,transect.getTime_of_transaction());
    }

    @Test
    void getTransaction_type() {
        assertEquals('d',transect.getTransaction_type());
    }
}