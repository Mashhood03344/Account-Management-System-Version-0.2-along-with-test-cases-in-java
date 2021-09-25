import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomersTest {

    Customers obj=new Customers("Henry","St 1","123");
    @Test
    void setName() {
        obj.setName("George");
        assertEquals("George",obj.getName());
    }

    @Test
    void setAddress() {
        obj.setAddress("Sector 1");
        assertEquals("Sector 1",obj.getAddress());
    }

    @Test
    void setPhone_Number() {
        obj.setPhone_Number("456");
        assertEquals("456",obj.getPhone_Number());
    }

    @Test
    void setNameFalse() {
        obj.setName("");
        assertNotEquals("",obj.getName());
    }

    @Test
    void setAddressFalse() {
        obj.setAddress("");
        assertNotEquals("",obj.getAddress());
    }

    @Test
    void setPhone_NumberFalse() {
        obj.setPhone_Number("");
        assertNotSame("",obj.getPhone_Number());
    }

    @Test
    void getName() {
        assertEquals("Henry",obj.getName());
    }

    @Test
    void getAddress() {
        assertEquals("St 1",obj.getAddress());
    }

    @Test
    void getPhone_Number() {
        assertEquals("123",obj.getPhone_Number());
    }
}