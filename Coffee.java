package aa;

public class Coffee extends Beverage {
	//extra shot or syrup boolean 
    private boolean extraShot;
    private boolean extraSyrup;
    //cost of extras
    private final double EXTRA_COST = 0.5;
    
    //string name, size
    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    //calc price
    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) price += EXTRA_COST;
        if (extraSyrup) price += EXTRA_COST;
        return price;
    }
    
    //ask the user if they want an extra shot or syrup
    @Override
    public String toString() {
        return super.toString() + (extraShot ? " + Extra Shot" : "") + (extraSyrup ? " + Extra Syrup" : "") + " - $" + calcPrice();
    }
}
