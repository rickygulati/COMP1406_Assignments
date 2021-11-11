public class Laptop extends Computer {
    private double screenSize;

    public Laptop(double price, int quantity, double cpuSpeed, int ram, boolean ssd, int storage, double screenSize){
        super(price, quantity, cpuSpeed, ram, ssd, storage);
        this.screenSize = screenSize;
    }

    public String toString() {
        if (getSsd() == true) {
            return (String.format("%.1f", screenSize) + " inch Laptop PC with " + String.format("%.1f", getCpuSpeed()) + "ghz CPU, " + getRam() + "GB RAM, " + getStorage() + "GB SSD drive.\n($" + String.format("%4.1f", getPrice()) + " each, " + getStockQuantity() + " in stock, " + getSoldQuantity() + " sold)");
        }
        else{
            return (String.format("%.1f", screenSize) + " inch Laptop PC with " + String.format("%.1f", getCpuSpeed()) + "ghz CPU, " + getRam() + "GB RAM, " + getStorage() + "GB HDD drive.\n($" + String.format("%4.1f", getPrice()) + " each, " + getStockQuantity() + " in stock, " + getSoldQuantity() + " sold)");

        }
    }
}
