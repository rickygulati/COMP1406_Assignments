public class Product {
    private double price;
    private int stockQuantity;
    private int soldQuantity;

    public Product(double price, int quantity){
        this.price = price;
        stockQuantity = quantity;
        soldQuantity = 0;
    }

    public double sellUnits(int amount){
        if(stockQuantity >= amount && amount >= 0){
            soldQuantity += amount;
            stockQuantity -= amount;
            return ((double)amount * price);
        }
        else{
            return 0.0;
        }
    }

    public double getPrice(){return price;}
    public int getStockQuantity(){return stockQuantity;}
    public int getSoldQuantity(){return soldQuantity;}

    public void setStockQuantity(int x){stockQuantity -= x;}
    public void setSoldQuantity(int x){soldQuantity = x;}

}
