public class Fridge {
    double Size;
    boolean HasFreezer; // If true, it has a freezer. Else it does not have a freezer.
    String Color;
    public String toString(){
        if(HasFreezer == true){
        return(Size + "cubic foot Fridge with Freezer(" + Color + ")");
        }
        else{
            return(Size + "cubic foot Fridge without Freezer(" + Color + ")");
        }
    }
    public Fridge(double s, boolean b, String c){
        Size = s;
        HasFreezer = b;
        Color = c;
    }
}
