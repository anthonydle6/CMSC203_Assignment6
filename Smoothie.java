package aa;

import java.util.Objects;

public class Smoothie extends Beverage {

    //constants
    private static final double PROTEIN_COST = 1.50;
    private static final double FRUIT_COST = 0.50;

    //instance variables
    private int numFruits;
    private boolean proteinAdded;

    //name, size of smoothie; number of fruits & protein
    public Smoothie(String name, Size size, int nF, boolean p) {
        super(name, "Smoothie", size);
        this.numFruits = nF;
        this.proteinAdded = p;
    }

    //calc price 
    @Override
    public double calcPrice() {
        double totalPrice = addSizePrice();
        //add cost of fruits 
        totalPrice += numFruits * FRUIT_COST; 
        if (proteinAdded) {
        	//add cost of protein
            totalPrice += PROTEIN_COST; 
        }
        return totalPrice;
    }

    //tostring over; name size & extras
    @Override
    public String toString() {
        return String.format("%s (%s) - Size: %s, Protein Added: %s, Number of Fruits: %d, Price: $%.2f",
            name, type, size, (proteinAdded ? "Yes" : "No"), numFruits, calcPrice());
    }

    //equals over
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Smoothie smoothie = (Smoothie) o;
        return numFruits == smoothie.numFruits && proteinAdded == smoothie.proteinAdded;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numFruits, proteinAdded);
    }

    //setter and getter
    public int getNumFruits() {
        return numFruits;
    }

    public void setNumFruits(int numFruits) {
        this.numFruits = numFruits;
    }

    public boolean isProteinAdded() {
        return proteinAdded;
    }

    public void setProteinAdded(boolean proteinAdded) {
        this.proteinAdded = proteinAdded;
    }

	@Override
	protected Object getType() {
		return null;
	}
}


