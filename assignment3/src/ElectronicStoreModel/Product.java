package ElectronicStoreModel;

//Base class for all products the store will sell
public class Product{
 private double price;
 private int stockQuantity;
 private int soldQuantity;
 private int cartQuantity;
 
 public Product(double initPrice, int initQuantity){
   price = initPrice;
   stockQuantity = initQuantity;
 }
 
 public int getStockQuantity(){
   return stockQuantity;
 }
 
 public int getSoldQuantity(){
   return soldQuantity;
 }
 
 public double getPrice(){
   return price;
 }

    public int getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(int cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    //Returns the total revenue (price * amount) if there are at least amount items in stock
 //Return 0 otherwise (i.e., there is no sale completed)
 public double sellUnits(){
   if(cartQuantity > 0 && stockQuantity >= cartQuantity){
     stockQuantity -= cartQuantity;
     soldQuantity += cartQuantity;
     double temp = cartQuantity;
     cartQuantity = 0;
     return price * temp;
   }
   return 0.0;
 }
}