public abstract class Computer extends Product {
    private double cpuSpeed;
    private int ram;
    private boolean ssd;
    private int storage;

    public Computer(double xPrice, int xQuantity, double cpuSpeed, int ram, boolean ssd, int storage){
        super(xPrice, xQuantity);
        this.cpuSpeed = cpuSpeed;
        this.ram = ram;
        this.ssd = ssd;
        this.storage = storage;
    }

    public double getCpuSpeed(){return cpuSpeed;}
    public int getRam(){return ram;}
    public boolean getSsd(){return ssd;}
    public int getStorage(){return storage;}

}
