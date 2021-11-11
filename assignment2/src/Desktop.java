public class Desktop extends Computer {
    private String profile;

    public Desktop(double price, int quantity, double cpuSpeed, int ram, boolean ssd, int storage, String profile){
        super(price, quantity, cpuSpeed, ram, ssd, storage);
        this.profile = profile;
    }

    public String toString() {
        if (getSsd() == true) {
            return (profile + " Desktop PC with " + String.format("%.1f", getCpuSpeed()) + "ghz CPU, " + getRam() + "GB RAM, " + getStorage() + "GB SSD drive.\n($" + String.format("%4.1f", getPrice()) + " each, " + getStockQuantity() + " in stock, " + getSoldQuantity() + " sold)");
        }
        else{
            return (profile + " Desktop PC with " + String.format("%.1f", getCpuSpeed()) + "ghz CPU, " + getRam() + "GB RAM, " + getStorage() + "GB HDD drive.\n($" + String.format("%4.1f", getPrice()) + " each, " + getStockQuantity() + " in stock, " + getSoldQuantity() + " sold)");

        }
    }
}


