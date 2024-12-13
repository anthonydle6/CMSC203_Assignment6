package aa;

import java.util.Objects;

public class Alcohol extends Beverage 
{

    // constants
    private static final double WEEKEND_COST = 0.60;

    // instance variables
    private boolean offeredOnWeekend;

 
    public Alcohol(String name, Size size, boolean offeredOnWeekend) 
    {
        super(name, "Alcohol", size);
        this.offeredOnWeekend = offeredOnWeekend;
    }

    //calculate price 
    @Override
    public double calcPrice() 
    {
        double totalPrice = addSizePrice();
        if (offeredOnWeekend) 
        {
        	//weekend cost if needed
            totalPrice += WEEKEND_COST; 
        }
        return totalPrice;
    }

    //name, size, offer
    @Override
    public String toString() 
    {
        return String.format("%s (%s) - Size: %s, Offered on Weekend: %s, Price: $%.2f",
            name, type, size, (offeredOnWeekend ? "Yes" : "No"), calcPrice());
    }

    //check bev equality 
    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Alcohol alcohol = (Alcohol) o;
        return offeredOnWeekend == alcohol.offeredOnWeekend;
    }

    @Override
    public int hashCode() 
    {
        return Objects.hash(super.hashCode(), offeredOnWeekend);
    }

    // setters and getters 
    public boolean isOfferedOnWeekend() 
    {
        return offeredOnWeekend;
    }

    public void setOfferedOnWeekend(boolean offeredOnWeekend) 
    {
        this.offeredOnWeekend = offeredOnWeekend;
    }

	@Override
	protected Object getType() 
	{
		return null;
	}
}

