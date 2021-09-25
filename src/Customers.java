import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Customers{
    private String name;
    private String address;
    private String phone_Number;

    public Customers(){
    }

    public Customers(String n, String a, String p){
        name= n;
        address=a;
        phone_Number=p;

    }

    public void setName(String name) {
        if(name!="")
            this.name = name;

        else{
            System.out.println("The name cannot be set to NULL");
        }
    }

    public void setAddress(String address) {
        if(address!="")
            this.address = address;

        else{
            System.out.println("The address cannot be set to NULL");
        }
    }

    public void setPhone_Number(String phone_Number) {
        if(phone_Number!="")
            this.phone_Number = phone_Number;

        else{
            System.out.println("The Phone number cannot be set to NULL");
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone_Number() {
        return phone_Number;
    }
}

