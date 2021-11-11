// Student number: 101146071
// Student name: Ricky Gulati
import java.util.Scanner;
public class ElectronicStoreTester {
    public static void main(String[] args){
        ElectronicStore E = new ElectronicStore("Astral Electronics");
        E.printStock();
        Scanner n = new Scanner(System.in);
        while(true){
            System.out.print("Enter an item to search for: ");
            String str = n.nextLine();
            if(str.equalsIgnoreCase("quit")){
                break;
            }
            else if(E.searchStock(str)){
                System.out.println("A matching item is available in the store.");
            }
            else{
                System.out.println("No related item available in the store.");
            }

        }
    }
}
