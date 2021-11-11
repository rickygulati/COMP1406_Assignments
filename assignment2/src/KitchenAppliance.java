public abstract class KitchenAppliance extends Product {
    private int wattage;
    private String color;
    private String brand;

    public KitchenAppliance(double price, int quantity, int wattage, String color, String brand){
        super(price, quantity);
        this.wattage = wattage;
        this.color = color;
        this.brand = brand;

    }

    public int getWattage(){return wattage;}
    public String getColor(){return color;}
    public String getBrand(){return brand;}

}
