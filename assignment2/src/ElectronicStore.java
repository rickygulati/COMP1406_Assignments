import java.util.Scanner;

public class ElectronicStore {
    final int MAX_PRODUCTS = 10;
    private String name;
    private double revenue;
    private Product[] products;

    public ElectronicStore(String name){
        this.name = name;
        revenue = 0.0;
        products = new Product[MAX_PRODUCTS];
    }

    public String getName() {
        return name;
    }

    public boolean addProduct(Product p) {
        //   for(Product x: products){
        //     if(x == null){
        //       x = p;
        //     return true;
     /*       }
        }
        return false;
    }
*/
    for(int i = 0; i < products.length; i++) {
        if (products[i] == null) {
            products[i] = p;
            return true;
        }
    }
    return false;
    }

    public void sellProducts(){
        printStock();

        Scanner s = new Scanner(System.in);
        System.out.print("Enter the index of the product you wish to sell: ");
        int choice = s.nextInt();
        if(products[choice] != null && choice < MAX_PRODUCTS && choice >= 0){
            System.out.print("Enter the amount of units you wish to sell of the product: ");
            int amount = s.nextInt();
            if(amount > 0){
                sellProducts(choice, amount);
            }

        }
    }

    public void sellProducts(int item, int amount) {
        if (item < 10 && item >= 0 && products[item] != null) {
            revenue += products[item].sellUnits(amount);
        }
    }

    public double getRevenue(){return revenue;}

    public void printStock(){
        for(int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.print(i + ". " + products[i]);
                System.out.println();
            }
        }
    }

}
