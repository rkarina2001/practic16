package exercise;

public class Customer {
    public Customer(String firstName, String secondName, int age, Address adress) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.adress = adress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAdress() {
        return adress;
    }

    String firstName;
    String secondName;
    int age;
    Address adress;
    Customer MATURE_UNKNOWN_CUSTOMER;
    Customer NOT_MATURE_UNKNOWN_CUSTOMER;
}
