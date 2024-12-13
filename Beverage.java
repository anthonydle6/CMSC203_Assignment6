package aa;

public abstract class Beverage 
{
	//name type size
    private String name;
    private Type type;
    private Size size;
    
    //base price, size adjustment 
    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 0.5;

    public Beverage(String name, Type type, Size size) 
    {
        this.name = name;
        this.type = type;
        this.size = size;
    }
    
    //price adjustment based on size 
    public double addSizePrice() 
    {
        switch (size) 
        {
            case MEDIUM:
                return BASE_PRICE + SIZE_PRICE;
            case LARGE:
                return BASE_PRICE + 2 * SIZE_PRICE;
            default:
                return BASE_PRICE;
        }
    }

    public abstract double calcPrice();

    //return name, size
    @Override
    public String toString() {
        return name + " (" + size + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Beverage) {
            Beverage other = (Beverage) obj;
            return name.equals(other.name) && type == other.type && size == other.size;
        }
        return false;
    }

	protected Object getType() {
		return null;
	}

}
