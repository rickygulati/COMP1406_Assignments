public class Desktop {
    double Speed;
    int RAM;
    int Storage;
    boolean Storage_type; //If true, then it is SSD. If false, it is HDD.
    public Desktop(double sp, int r, int str, boolean t){
        Speed = sp;
        RAM = r;
        Storage = str;
        Storage_type = t;
    }
    public String toString() {
        if (Storage_type == true) {
            return ("This is a Desktop PC with " + Speed + "Ghz CPU, " + RAM + "GB RAM, " + Storage + "GB SSD Drive");
        }
        else{
            return ("This is a Desktop PC with " + Speed + "Ghz CPU, " + RAM + "GB RAM, " + Storage + "GB HDD Drive");
        }

    }
}
