public class Fridge extends KitchenAppliance {
    private double cubicFeet;
    private boolean hasFreezer;

    public Fridge(double price, int quantity, int wattage, String color, String brand, double cubicFeet, boolean hasFreezer){
        super(price, quantity, wattage, color, brand);
        this.cubicFeet = cubicFeet;
        this.hasFreezer = hasFreezer;
    }

    public double getCubicFeet(){return cubicFeet;}
    public boolean isHasFreezer(){return hasFreezer;}

    public String toString(){
        if(isHasFreezer() == true){
        return(String.format("%3.1f", cubicFeet) + " cu. ft. " + getBrand() + " Fridge with Freezer(" + getColor() + ", " + getWattage() + " watts)\n($" + String.format("%4.1f", getPrice()) + " each, " + getStockQuantity() + " in stock, " + getSoldQuantity() + " sold)");
    }
        else{
            return(String.format("%3.1f", cubicFeet) + " cu. ft. " + getBrand() + " Fridge (" + getColor() + ", " + getWattage() + " watts)\n($" + String.format("%4.1f", getPrice()) + " each, " + getStockQuantity() + " in stock, " + getSoldQuantity() + " sold)");

        }

    }
}
