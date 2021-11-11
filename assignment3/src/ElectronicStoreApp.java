import ElectronicStoreModel.ElectronicStore;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {
    ElectronicStore model;
    ElectronicStoreView view;
    Stage theStage;

    public void start(Stage primaryStage){
        theStage = primaryStage;
        model = ElectronicStore.createStore();
        view = new ElectronicStoreView(model);

        view.getAddToCart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleAddToCart();
            }
        });

        view.getRemoveFromCart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleRemoveFromCart();
            }
        });

        view.getCompleteSale().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleCompleteSale();
            }
        });

        view.getResetStore().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleResetStore();
            }
        });

        view.getStoreStock().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleStoreStockSelection();
            }
        });

        view.getCurrentCart().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                handleCurrentCartSelection();
            }
        });

        theStage.setTitle(model.getName());
        theStage.setResizable(false);
        theStage.setScene(new Scene(view, 834, 455));
        theStage.show();
        view.update();
    }

    public void handleStoreStockSelection(){
        view.getAddToCart().setDisable(false);
        view.update();
    }

    public void handleAddToCart(){
        view.getAddToCart().setDisable(true);
        view.getCompleteSale().setDisable(false);
        model.enterToCart(view.getStoreStock().getSelectionModel().getSelectedItem());
        view.getStoreStock().getSelectionModel().clearSelection();
        view.update();
    }

    public void handleCurrentCartSelection() {
        if (view.getCurrentCart().getSelectionModel().getSelectedIndex() >= 0) {
            view.getRemoveFromCart().setDisable(false);
            view.update();
        }
    }

    public void handleRemoveFromCart(){
        model.popFromCart(view.getCurrentCart().getSelectionModel().getSelectedItem());
        view.getCurrentCart().getSelectionModel().clearSelection();
        if(model.getCartRevenue() == 0){
            view.getCompleteSale().setDisable(true);
        }
        view.getRemoveFromCart().setDisable(true);
        view.update();
    }


    public void handleResetStore(){
        start(theStage);
    }

    public void handleCompleteSale(){
        view.getCompleteSale().setDisable(true);
        view.getRemoveFromCart().setDisable(true);
        view.getAddToCart().setDisable(true);
        model.confirmSale();
        view.update();
    }

    public static void main(String[] args) { launch(args);}


}
