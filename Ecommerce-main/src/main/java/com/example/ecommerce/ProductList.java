package com.example.ecommerce;

//public class ProductList {
//}
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductList {

    public static TableView<Product> productTable;

    public static void removerow() {
        Product pro=productTable.getSelectionModel().getSelectedItem();
        productTable.getItems().remove(pro);
    }


    public Pane getAllProducts(){
        TableColumn id = new TableColumn("Item");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("Mobile");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn quantity = new TableColumn("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        ObservableList<Product> productsList = Product.getAllProducts();

        productTable = new TableView<>();
        productTable.setItems(productsList);
        productTable.getColumns().addAll(id, name, price, quantity);

        Pane tablePane = new Pane();
        tablePane.getChildren().add(productTable);

        return tablePane;
    }
    public Pane getorderedlist(Customer loggedInCustomer){
        TableColumn id = new TableColumn("Item");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("Laptop");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        String query = "select * from yourorders where cid="+ loggedInCustomer.getId();
        ObservableList<Product> productsList = Product.getorders(query);
        productTable = new TableView<>();
        productTable.setItems(productsList);
        productTable.getColumns().addAll(id, name, price);

        Pane tablePane = new Pane();
        tablePane.getChildren().add(productTable);

        return tablePane;
    }
    public Pane getAllSearchedProducts(String searchName){
        TableColumn id = new TableColumn("Item");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("Mobile");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn price = new TableColumn("Price");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn quantity = new TableColumn("Quantity");
        quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // select * from products where name like 'a%';
        String query = "select * from products where name like '" + searchName + "%'";
        ObservableList<Product> productsList = Product.getProducts(query);

        productTable = new TableView<>();
        productTable.setItems(productsList);
        productTable.getColumns().addAll(id, name, price, quantity);

        Pane tablePane = new Pane();
        tablePane.getChildren().add(productTable);

        return tablePane;
    }
    public Product getSelectedProduct() {
        // getting selected item
        return productTable.getSelectionModel().getSelectedItem();
    }
}