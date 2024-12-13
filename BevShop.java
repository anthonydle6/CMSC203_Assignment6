package aa;

import java.util.ArrayList;
import java.util.List;

/**
 * BevShop class that implements BevShopInterface and represents a beverage shop.
 */
public class BevShop implements BevShopInterface {
	//storage of all orders 
	//num of alc beverages ordered and tracked
	//monthly sales
	//active order
    private List<Order> orders;
    private int numAlcoholOrdered; 
    private double totalSales; 
    private Order currentOrder; 

    public BevShop() {
        orders = new ArrayList<>();
        numAlcoholOrdered = 0;
        totalSales = 0.0;
        currentOrder = null;
    }

    ///reset number of alc drinks; new order
    @Override
    public void startNewOrder(boolean flag) {
        this.currentOrder = new Order(null, null, null);
        numAlcoholOrdered = 0; 
        orders.add(this.currentOrder);
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        if (currentOrder != null) {
            currentOrder.addNewBeverage(new Coffee(bevName, size, extraShot, extraSyrup));
        }
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (currentOrder != null && numAlcoholOrdered < 3) {
            currentOrder.addNewBeverage(new Alcohol(bevName, size, false));
            numAlcoholOrdered++;
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (currentOrder != null) {
            currentOrder.addNewBeverage(new Smoothie(bevName, size, numOfFruits, addProtein));
        }
    }

    @Override
    public String calculateTotalSales() {
        double total = 0;
        for (Order order : orders) {
            total += order.calculateTotalPrice();
        }
        return String.format("%.2f", total);
    }

    @Override
    public String getNumOfOrders() {
        return String.valueOf(orders.size());
    }

    public void addSmoothie(String string, Size small, int s, boolean o) {
        processSmoothieOrder(string, small, s, o);
    }

    public void addCoffee(String string, Size medium, boolean c, boolean m) {
        processCoffeeOrder(string, medium, c, m);
    }

    public void addAlcohol(String string, Size large) {
        processAlcoholOrder(string, large);
    }

    @Override
    public Object getCurrentOrder() {
        if (currentOrder != null) {
            Order copiedOrder = new Order(null, null, null);
            copiedOrder.setOrderName(currentOrder.getCustomerName());
            copiedOrder.setTotalPrice(currentOrder.calculateTotalPrice());
            return copiedOrder;
        }
        return null;
    }

    
    @Override
    public boolean isValidTime(int time) {
        return time >= 8 && time <= 23;
    }

    //max num for fruits
    @Override
    public int getMaxNumOfFruits() {
        return 5;
    }

    //min age for drinking
    @Override
    public int getMinAgeForAlcohol() {
        return 21;
    }

    //fruit max boolean
    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > getMaxNumOfFruits();
    }

    //max order for alc
    @Override
    public int getMaxOrderForAlcohol() {
        return 3;
    }

    //alc drinks boolean 
    @Override
    public boolean isEligibleForMore() {
        return numAlcoholOrdered < getMaxOrderForAlcohol();
    }

    //num of alc drinks ordered
    @Override
    public int getNumOfAlcoholDrink() {
        return numAlcoholOrdered;
    }

    //validate age
    @Override
    public boolean isValidAge(int age) {
        return age >= getMinAgeForAlcohol();
    }

    //print if its not the correct time or age
    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        if (!isValidTime(time)) {
            throw new IllegalArgumentException("Invalid order time.");
        }
        if (!isValidAge(customerAge)) {
            throw new IllegalArgumentException("Customer does not meet the age requirement.");
        }
        currentOrder = new Order(time, day, customerName, customerAge);
        numAlcoholOrdered = 0;
        orders.add(currentOrder);
    }

    //order num
	@Override
	public int findOrder(int orderNo) {
	    for (int i = 0; i < orders.size(); i++) {
	        if (orders.get(i).getOrderNo() == orderNo) {
	            return i;
	        }
	    }
	    return -1; 
	}

	//total price
	@Override
	public double totalOrderPrice(int orderNo) {
	    int index = findOrder(orderNo);
	    if (index != -1) {
	        return orders.get(index).calculateTotalPrice();
	    }
	    //if order isnt found 
	    return 0.0; 
	}

	//total monthly sales
	@Override
	public double totalMonthlySale() {
	    double total = 0.0;
	    for (Order order : orders) {
	        total += order.calculateTotalPrice();
	    }
	    return total;
	}

	//monthly orders
	@Override
	public int totalNumOfMonthlyOrders() {
	    return orders.size();
	}

	//order index
	@Override
	public Order getOrderAtIndex(int index) {
	    if (index >= 0 && index < orders.size()) {
	        return orders.get(index);
	    }
	    return null;
	}

	//order sort 
	@Override
	public void sortOrders() {
	    orders.sort((o1, o2) -> Integer.compare(o1.getOrderNo(), o2.getOrderNo()));
	}

}
