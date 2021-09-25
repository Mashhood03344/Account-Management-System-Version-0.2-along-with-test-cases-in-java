import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Accounts{
    protected int account_number;
    protected double balance;
    protected  String date_created;
    protected Customers cust = new Customers();
    protected static int account_count=0;
    protected ArrayList<Transaction> Transactions_array=new ArrayList<Transaction>();
    protected int transaction_count;
    protected String status;

    public Accounts(){
        account_count++;
        account_number=account_count;
        transaction_count=0;
        status="Deactive";
    }

    public Accounts(String n, String a,String p,double b, String dc){
        account_count++;
        account_number=account_count;
        balance=b;
        date_created=dc;
        transaction_count=0;
        cust.setName(n);
        cust.setAddress(a);
        cust.setPhone_Number(p);
        status="Active";
    }

    public void checkBalance(){
        System.out.println("Bank Account Holder Name: "+cust.getName());
        System.out.println("Account Number: "+account_number);
    }

    public void makeDeposit(double amount){
        if(amount<=0){
            System.out.println("The amount you have Entered is Negative or 0. So you cannot make the deposit");
        }

        else{
            balance+=amount;

            LocalDate obj=LocalDate.now();
            LocalTime obj1=LocalTime.now();

            char ty ='d'; //for transaction_type

            Transactions_array.add(new Transaction(amount,obj,obj1,ty));
            ++transaction_count;
        }
    }

    public void printStatement(){

        System.out.println("_____________________________________________________________________________________________________________________________");
        System.out.println("                                                               Statement of the Recent Transaction");

        if (transaction_count<=0){
            System.out.println("No Current Transaction to Show");
        }

        else {

            for(int i=0;i<transaction_count;i++) {

                System.out.println("_____________________________________________________________________________________________________________________________");
                System.out.println("");
                System.out.println("Customer Name: " + cust.getName());
                System.out.println("Customer Name: " + cust.getAddress());
                System.out.println("Customer Name: " + cust.getPhone_Number());

                //Printing the time and date of the transaction
                System.out.println("Transaction Date: " + Transactions_array.get(i).getDate_of_transaction());
                System.out.println("Transaction Time: " + Transactions_array.get(i).getTime_of_transaction());
                System.out.println("Transaction Type (w for Withdrawl, d for Deposit): "+ Transactions_array.get(i).getTransaction_type());
                System.out.println("Transaction Amount: " + Transactions_array.get(i).getTransaction_amount());
                System.out.println("Remaining Balance: $" + balance);

            }
        }

        System.out.println("_____________________________________________________________________________________________________________________________");

    }

    public void makeWithdrawal(double amount){
        if (amount>balance){
            System.out.println("The amount you have Entered Exceeds your balance. So the withdrawl cannot be made");
        }

        else if(amount<=0){
            System.out.println("The Withdrawl amount cannot be zero or negative. So the withdrawl cannot be made");
        }

        else{
            balance-=amount;

            LocalDate obj=LocalDate.now();
            LocalTime obj1=LocalTime.now();
            char ty ='w'; //for transaction_type

            Transactions_array.add(new Transaction(amount,obj,obj1,ty));
            ++transaction_count;

        }
    }

    public double calculateZakat(){
        double zakat=0;

        zakat = (2.5*balance)/100;

        System.out.println("Calculated Zakat: $"+zakat);

        return zakat;
    }

    public void displayAllDeductions(){

        System.out.println("_____________________________________________________________________________________________________________________________");
        System.out.println("                                                              Displaying all the Deductions");

        double deduct_amount=balance- calculateZakat();

        System.out.println("_____________________________________________________________________________________________________________________________");

    }

    public void setBalance(double amount){
        if(amount>0)
            balance=amount;

        else{
            System.out.println("The Balance cannot be less than zero or negative");
        }
    }

    public void setDate_created(String date){
        if(date!="")
            date_created=date;

        else{
            System.out.println("The date of creation of the account cannot be set to NULL");
        }
    }

}

/////////////////////////////////Current Account class
class Current_Account extends Accounts{
    private int transaction_fee_initiation_count;
    private int total_transaction_fees_paid;

    public Current_Account(){
        transaction_fee_initiation_count=0;
        total_transaction_fees_paid=0;
    }

    public Current_Account(String n, String a,String p,double b, String dc){

        super(n,a,p,b,dc);
        transaction_fee_initiation_count=0;
        total_transaction_fees_paid=0;

    }

    public void makeDeposit(double amount){
        if(amount<=0){
            System.out.println("The amount you have Entered is Negative or 0. So you cannot make the deposit");
        }

        else{

            if(transaction_fee_initiation_count>=2){
                balance-=10;
                total_transaction_fees_paid+=10;
            }

            transaction_fee_initiation_count++;
            balance+=amount;

            LocalDate obj=LocalDate.now();
            LocalTime obj1=LocalTime.now();

            char ty ='d'; //for transaction_type

            Transactions_array.add(new Transaction(amount,obj,obj1,ty));
            transaction_count++;
        }
    }

    public void makeWithdrawal(double amount){
        if (amount>balance){
            System.out.println("The amount you have Entered Exceeds your balance. So the withdrawl cannot be made");
        }

        else if(amount<=0){
            System.out.println("The Withdrawl amount cannot be zero or negative. So the withdrawl cannot be made");
        }

        else{

            if(transaction_fee_initiation_count>=2){
                balance-=10;
                total_transaction_fees_paid+=10;
            }

            transaction_fee_initiation_count++;

            balance-=amount;

            LocalDate obj=LocalDate.now();
            LocalTime obj1=LocalTime.now();
            char ty ='w'; //for transaction_type

            Transactions_array.add(new Transaction(amount,obj,obj1,ty));
            transaction_count++;

        }
    }

    public int getTransaction_fee_initiation_count(){
        return transaction_fee_initiation_count;
    }

    public int getTotal_transaction_fees_paid() {
        return total_transaction_fees_paid;
    }
}

///////////////////////////////////////////Savings Account class/////////////////////////////////////////////

class Savings_Account extends Accounts{

    double interest_rate;

    public Savings_Account(){
        interest_rate=0.5;
    }

    public Savings_Account(String n, String a,String p,double b, String dc, double i){
        super(n,a,p,b,dc);

        interest_rate=i;
    }

    public void setInterest_rate(double i){
        if(i<=0){
            System.out.println("The interest rate cannot be negative or less than zero. So the setter will method will not invoke");
        }

        else {
            interest_rate = i;
        }
    }

    public double calculatelnterest(){

        double interest=balance*interest_rate;

        return interest;
    }

}

////////////////////////////////Transactions class//////////////////////////////////////////
class Transaction{
    private double transaction_amount;
    private LocalDate date_of_transaction;
    private LocalTime time_of_transaction;
    private char transaction_type;

    public Transaction(){

    }

    public Transaction(double am,LocalDate date,LocalTime time,char c){
        transaction_amount=am;
        date_of_transaction=date;
        time_of_transaction=time;
        transaction_type=c;
    }

    public void setTransaction_amount(double amount){
        if(amount>0){
            transaction_amount=amount;
        }

        else{
            System.out.println("The Transaction amount cannot be negative");
        }
    }

    public void setCurr_date(LocalDate date){
        date_of_transaction=date;
    }

    public void setCurr_time(LocalTime time){
        time_of_transaction=time;
    }

    public void setTransaction_type(char type){
        if(transaction_type!='w'&& transaction_type!='d'){
            System.out.println("Transaction Type can only be w or d (Lower Case)");
        }

        else if (type=='w'){
            transaction_type=type;
        }

        else if(type=='d'){
            transaction_type=type;
        }
    }
    public double getTransaction_amount() {
        return transaction_amount;
    }

    public LocalDate getDate_of_transaction(){
        return date_of_transaction;
    }

    public LocalTime getTime_of_transaction(){
        return time_of_transaction;
    }

    public char getTransaction_type(){
        return transaction_type;
    }

}

