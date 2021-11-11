public class ToasterOven extends KitchenAppliance {
    private int width;
    private boolean convection;

    public ToasterOven(double price, int quantity, int wattage, String color, String brand, int width, boolean convection){
        super(price, quantity, wattage, color, brand);
        this.width = width;
        this.convection = convection;
    }

    public int getWidth(){return width;}
    public boolean hasConvection(){return convection;}

    public String toString() {
        if (hasConvection() == true) {
            return (width + " inch " + getBrand() + " Toaster with Convection (" + getColor() + ", " + getWattage() + " watts)\n($" + String.format("%4.1f", getPrice()) + " each, " + getStockQuantity() + " in stock, " + getSoldQuantity() + " sold)");
        }
        else{
            return (width + " inch " + getBrand() + " Toaster (" + getColor() + ", " + getWattage() + " watts)\n($" + String.format("%4.1f", getPrice()) + " each, " + getStockQuantity() + " in stock, " + getSoldQuantity() + " sold)");

        }
    }
}
