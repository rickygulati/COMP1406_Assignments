public class ElectronicStore {
    String name;
    Desktop[] D = new Desktop[3];
    Laptop[] L = new Laptop[3];
    Fridge[] F = new Fridge[3];

    public ElectronicStore(String s) {
        name = s;
        D[0] = new Desktop(4.2, 16, 512, true);
        D[1] = new Desktop(3.3, 8, 256, false);
        D[2] = new Desktop(3.9, 12, 512, true);

        L[0] = new Laptop(2.9, 16, 256, true, 15);
        L[1] = new Laptop(3.4, 8, 256, false, 13);
        L[2] = new Laptop(3.7, 16, 128, true, 17);

        F[0] = new Fridge(14.6, true, "Black");
        F[1] = new Fridge(12.3, false, "Navy Blue");
        F[2] = new Fridge(15.1, false, "White");

    }

    public void printStock() {
        System.out.println("The store has the following products in stock: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(D[i]);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(L[i]);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(F[i]);
        }

    }

    public boolean searchStock(String s) {
        boolean flag = false;
        s = s.toUpperCase();
        for (int i = 0; i < 3; i++) {
            String x = D[i].toString().toUpperCase();
            if (x.contains(s)) {
                flag = true;
                break;
            } else {

                x = L[i].toString().toUpperCase();
                if (x.contains(s)) {
                    flag = true;
                    break;
                } else {

                    x = F[i].toString().toUpperCase();
                    if (x.contains(s)) {
                        flag = true;
                        break;
                    }
                    else{
                        flag = false;
                    }
                }
            }

        }
        return flag;
    }
}





