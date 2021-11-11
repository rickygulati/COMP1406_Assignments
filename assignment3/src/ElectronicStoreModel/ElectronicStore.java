package ElectronicStoreModel;//Class representing an electronic store
//Has an array of products that represent the items the store can sell

import java.util.ArrayList;

public class ElectronicStore{
  public final int MAX_PRODUCTS = 10; //Maximum number of products the store can have
  private int curProducts;
  private String name;
  private Product[] stock; //Array to hold all products
  private double revenue;
  private ArrayList<Product> cart;
  private double cartRevenue;
  private Product[] mostPopularItems;
  private int sales;


  
  public ElectronicStore(String initName){
    revenue = 0.0;
    name = initName;
    stock = new Product[MAX_PRODUCTS];
    curProducts = 0;
    cart = new ArrayList<>();
    cartRevenue = 0.0;
    mostPopularItems = new Product[MAX_PRODUCTS];
    sales = 0;
  }
  
  public String getName(){
    return name;
  }
  
  //Adds a product and returns true if there is space in the array
  //Returns false otherwise
  public boolean addProduct(Product newProduct){
    if(curProducts < MAX_PRODUCTS){
     stock[curProducts] = newProduct;
     curProducts++;
     return true;
    }
    return false;
  }
  
  //Sells 'amount' of the product at 'index' in the stock array
  //Updates the revenue of the store
  //If no sale occurs, the revenue is not modified
  //If the index is invalid, the revenue is not modified
  private void sellProducts(int index){
    if(index >= 0 && index < curProducts){
      revenue += stock[index].sellUnits();
    }
  }
  
  public double getRevenue(){
    return revenue;
  }

  public double getCartRevenue() {
    return cartRevenue;
  }

  public ArrayList<String> getStock(){
    ArrayList<String> products = new ArrayList<>();
    for(int i = 0; i < curProducts; i++){
      if(stock[i].getCartQuantity() + stock[i].getSoldQuantity() < 10){
        products.add(stock[i].toString());
      }
    }
    return products;
  }

  public ArrayList<String> getTopPopularItems(){
    ArrayList<String> topItems = new ArrayList<>();
    for(int i = 0; i < 3; i++) {
      if (mostPopularItems[i] != null && mostPopularItems[i].getSoldQuantity() != 0) {
        topItems.add(mostPopularItems[i].toString());
      }
    }
    return topItems;
  }

  public int getSales() {
    return sales;
  }

  //To add products to the cart
  public void enterToCart(String item){
    for(int i = 0; i < curProducts; i++){
      if(item.equals(stock[i].toString()) && (stock[i].getStockQuantity() - stock[i].getCartQuantity()) > 0){
        stock[i].setCartQuantity(stock[i].getCartQuantity() + 1);
        cart.add(stock[i]);
        cartRevenue += stock[i].getPrice();
        break;
      }
    }
  }

  public String[] getCart() {
    String[] cartItems = new String[cart.size()];
    for(int i = 0; i < cart.size(); i++){
      cartItems[i] = cart.get(i).toString();
    }
    return cartItems;
  }

  //To remove products from cart
  public void popFromCart(String item){
    for(int i = 0; i < curProducts; i++){
      if(item.equals(stock[i].toString())){
        stock[i].setCartQuantity(stock[i].getCartQuantity() - 1);
        cartRevenue -= stock[i].getPrice();
        cart.remove(stock[i]);
        break;
      }
    }
  }

  private void computeMostPopular(){
    mostPopularItems = stock.clone();
    for(int i = 0; i < 3; i++){
      int top = i;
      for(int j = i + 1; j < curProducts; j++){
        if(mostPopularItems[top].getSoldQuantity() < mostPopularItems[j].getSoldQuantity()){
          top = j;
        }
      }

      Product temp = mostPopularItems[i];
      mostPopularItems[i] = mostPopularItems[top];
      mostPopularItems[top] = temp;
    }
  }

  //To confirm sale
  public void confirmSale(){
    sales++;
    cartRevenue = 0.0;
    for(int i = 0; i < curProducts; i++){
      sellProducts(i);
    }
    cart.clear();
    computeMostPopular();
  }


  
  public static ElectronicStore createStore(){
    ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
    Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
    Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
    Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
    Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
    Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", 15.5, false);
    Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", 23, true);
    ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", 8, false);
    ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", 12, true);
    store1.addProduct(d1);
    store1.addProduct(d2);
    store1.addProduct(l1);
    store1.addProduct(l2);
    store1.addProduct(f1);
    store1.addProduct(f2);
    store1.addProduct(t1);
    store1.addProduct(t2);
    return store1;
  }
} 