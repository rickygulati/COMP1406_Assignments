public class Laptop {
    double Speed;
    int RAM;
    int Storage;
    boolean Storage_type; //If true, then it is SSD. If false, it is HDD.
    int Size;
    public Laptop(double sp, int r, int str, boolean t, int sz){
        Speed = sp;
        RAM = r;
        Storage = str;
        Size = sz;
        Storage_type = t;
    }
    public String toString() {
        if (Storage_type == true) {
            return ("This is a " + Size + "\"Laptop PC with " + Speed + "Ghz CPU, " + RAM + "GB RAM, " + Storage + "GB SSD Drive");
        }
        else{
            return ("This is a " + Size + "\"Laptop PC with " + Speed + "Ghz CPU, " + RAM + "GB RAM, " + Storage + "GB HDD Drive");
        }

    }
}
