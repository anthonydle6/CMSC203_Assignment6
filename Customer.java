package aa;

public class Customer 
{
    
    // instance variables
    private String name;
    private int age;

    //name and age of customer
    public Customer(String name, int age) 
    {
        this.name = name;
        this.age = age;
    }

    //customer object
    public Customer(Customer other) 
    {
        this.name = other.name;
        this.age = other.age;
    }

    //tostring for name & text
    @Override
    public String toString() 
    {
        return String.format("Customer Name: %s, Age: %d", name, age);
    }

    //name getter 
    public String getName() 
    {
        return name;
    }
    //name setter
    public void setName(String name) 
    {
        this.name = name;
    }
    //age getter 
    public int getAge() 
    {
        return age;
    }
    //age setter
    public void setAge(int age) 
    {
        this.age = age;
    }
}

