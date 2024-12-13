package aa;

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

    //instance variables
    private int orderNumber;
    private String orderTime;
    private String orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    //constructors
    public Order(String orderTime, String orderDay, Customer customer) {
        this.orderNumber = generateOrderNumber();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        //deep copy customer
        this.customer = new Customer(customer); 
        this.beverages = new ArrayList<>();
    }

    //rand number for order 
    private int generateOrderNumber() {
        Random rand = new Random();
        return rand.nextInt(90000 - 10000) + 10000;
    }

    //beverage methods 
    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public void addNewBeverage(Beverage beverage) {
        beverages.add(beverage);
    }

    @Override
    public void addNewBeverage(String beverageType, String size) {
        beverages.add(new Beverage(beverageType, Size.valueOf(size.toUpperCase())));
    }

    //calc order total
    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage bev : beverages) {
            total += bev.calcPrice();
        }
        return total;
    }

    //num of total beverages 
    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage bev : beverages) {
            if (bev.getType() == type) {
                count++;
            }
        }
        return count;
    }

    //weekend or not
    @Override
    public boolean isWeekend() {
        return orderDay.equalsIgnoreCase("Saturday") || orderDay.equalsIgnoreCase("Sunday");
    }

    //beverage, item number
    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo); // Shallow copy
        }
        return null;
    }

    //setter and getter
    @Override
    public int getOrderNumber() {
        return orderNumber;
    }

    @Override
    public String getCustomerName() {
        return customer.getName();
    }

    @Override
    public String getAge() {
        return String.valueOf(customer.getAge());
    }

    @Override
    public Object getBeverages() {
        return beverages;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(String orderDay) {
        this.orderDay = orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // Deep copy
    }

    public void setCustomer(Customer customer) {
        this.customer = new Customer(customer); // Deep copy
    }

    //compareto over
    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNumber, other.orderNumber);
    }

    //tostring over
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Number: ").append(orderNumber).append("\n");
        sb.append("Order Time: ").append(orderTime).append("\n");
        sb.append("Order Day: ").append(orderDay).append("\n");
        sb.append("Customer Name: ").append(customer.getName()).append("\n");
        sb.append("Customer Age: ").append(customer.getAge()).append("\n");
        sb.append("Beverages: \n");
        for (Beverage bev : beverages) {
            sb.append(bev.toString()).append("\n");
        }
        return sb.toString();
    }

	@Override
	public String getTotalItems() {
		return null;
	}

	@Override
	public int generateOrder() { 
		return 0;
	}
}

