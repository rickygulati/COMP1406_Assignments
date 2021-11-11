import ElectronicStoreModel.ElectronicStore;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextAlignment;


public class ElectronicStoreView extends Pane {
    private ListView<String> storeStock;
    private ListView<String> currentCart;
    private ListView<String> popularItems;

    private Button resetStore;
    private Button addToCart;
    private Button removeFromCart;
    private Button completeSale;

    private TextField sales;
    private TextField revenue;
    private TextField incomePerSale;

    private Label curCartLabel;

    private ElectronicStore model;

    public ElectronicStoreView(ElectronicStore initmodel){
        //Initialize model
        model = initmodel;

        //Initialize ListViews
        storeStock = new ListView<>();
        currentCart = new ListView<>();
        popularItems = new ListView<>();

        //Initialize Buttons
        resetStore = new Button("Reset store");
        addToCart = new Button("Add to cart");
        removeFromCart = new Button("Remove from cart");
        completeSale = new Button("Complete sale");

        //Initialize TextFields
        sales = new TextField("0");
        revenue = new TextField("0.0");
        incomePerSale = new TextField("N/A");

        //Initialize, relocate and setPrefSize Current Cart Label
        curCartLabel = new Label("Current Cart ($0.00):");
        curCartLabel.relocate(622, 20);
        curCartLabel.setPrefSize(120, 20);
        curCartLabel.setTextAlignment(TextAlignment.CENTER);

        //Declare, initialize, relocate and setPrefSize permanent labels
        Label salesLabel = new Label("# Sales:");
        salesLabel.relocate(25, 48);
        salesLabel.setPrefSize(60, 15);
        salesLabel.setTextAlignment(TextAlignment.RIGHT);

        Label revenueLabel = new Label("Revenue:");
        revenueLabel.relocate(15, 85);
        revenueLabel.setPrefSize(60, 15);
        revenueLabel.setTextAlignment(TextAlignment.RIGHT);

        Label incomePerSaleLabel = new Label("$ / Sale:");
        incomePerSaleLabel.relocate(20, 120);
        incomePerSaleLabel.setPrefSize(62, 15);
        incomePerSaleLabel.setTextAlignment(TextAlignment.RIGHT);

        Label storeSummaryLabel = new Label("Store Summary:");
        storeSummaryLabel.relocate(45, 20);
        storeSummaryLabel.setPrefSize(110, 20);
        storeSummaryLabel.setTextAlignment(TextAlignment.CENTER);

        Label popularItemsLabel = new Label("Most Popular Items:");
        popularItemsLabel.relocate(35, 155);
        popularItemsLabel.setPrefSize(135, 20);
        popularItemsLabel.setTextAlignment(TextAlignment.CENTER);

        Label storeStockLabel = new Label("Store Stock:");
        storeStockLabel.relocate(314, 20);
        storeStockLabel.setPrefSize(80, 20);
        storeStockLabel.setTextAlignment(TextAlignment.CENTER);

        //Relocate and setPrefSize ListViews
        storeStock.relocate(200, 42);
        storeStock.setPrefSize(300, 315);

        currentCart.relocate(515, 42);
        currentCart.setPrefSize(300, 315);

        popularItems.relocate(10, 182);
        popularItems.setPrefSize(185, 175);

        //Relocate and setPrefSize Buttons
        resetStore.relocate(25, 385);
        resetStore.setPrefSize(155, 55);
        resetStore.setTextAlignment(TextAlignment.CENTER);


        addToCart.relocate(275, 385);
        addToCart.setPrefSize(155, 55);
        addToCart.setTextAlignment(TextAlignment.CENTER);

        removeFromCart.relocate(510, 385);
        removeFromCart.setPrefSize(153, 55);
        removeFromCart.setTextAlignment(TextAlignment.CENTER);

        completeSale.relocate(664, 385);
        completeSale.setPrefSize(155, 55);
        completeSale.setTextAlignment(TextAlignment.CENTER);

        //Relocate and setPrefSize TextFields
        sales.relocate(70, 42);
        sales.setPrefSize(105, 25);

        revenue.relocate(70, 80);
        revenue.setPrefSize(105, 25);

        incomePerSale.relocate(70, 116);
        incomePerSale.setPrefSize(105, 25);

        //Disabling Buttons
        addToCart.setDisable(true);
        completeSale.setDisable(true);
        removeFromCart.setDisable(true);

        //Disabling TextFields
        sales.setEditable(false);
        revenue.setEditable(false);
        incomePerSale.setEditable(false);

        //Disabling popularItems ListView
        popularItems.setEditable(false);

        getChildren().addAll(storeStock, currentCart, popularItems, resetStore, addToCart, removeFromCart, completeSale, sales, revenue, incomePerSale, curCartLabel, salesLabel, revenueLabel, incomePerSaleLabel, storeStockLabel, storeSummaryLabel, popularItemsLabel);

    }

    public ListView<String> getStoreStock(){return storeStock;}
    public ListView<String> getCurrentCart(){return currentCart;}

    public Button getResetStore() { return resetStore; }
    public Button getAddToCart() { return addToCart; }
    public Button getCompleteSale() { return completeSale; }
    public Button getRemoveFromCart() { return removeFromCart; }

    public void update() {
        popularItems.setItems(FXCollections.observableArrayList(model.getTopPopularItems()));
        storeStock.setItems(FXCollections.observableArrayList(model.getStock()));
        currentCart.setItems(FXCollections.observableArrayList(model.getCart()));

        sales.setText("" + model.getSales());
        revenue.setText("" + String.format("%.2f", model.getRevenue()));
        if (model.getSales() != 0) {
            incomePerSale.setText("" + String.format("%.2f", (model.getRevenue() / model.getSales())));
        }
        else{
            incomePerSale.setText("N/A");
        }

        curCartLabel.setText("Current Cart($" + String.format("%.2f", model.getCartRevenue()) + "):");
    }


}
