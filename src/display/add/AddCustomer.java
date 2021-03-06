package display.add;

import display.main.DisplayInterface;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import services.Controller;
import services.Display;
import structures.Customer;

public class AddCustomer implements DisplayInterface{

    private GridPane pane;

    private TextField first_name = new TextField();
    private TextField last_name = new TextField();
    private TextField address = new TextField();
    private TextField payment = new TextField();

    public AddCustomer(Controller controller){

        this.pane = new GridPane();
        ComboBox<String> sex = new ComboBox<>();
        Button submit = new Button("Submit");
        Button payBtn = new Button("Payment");

        sex.getItems().addAll("Male", "Female");

        pane.add(new Label("First Name: "), 0,0);
        pane.add(new Label("Last Name: "), 2,0);
        pane.add(new Label("Address: "), 0,1);
        pane.add(new Label("Sex: "), 2,1);
        pane.add(new Label("Payment: "),4,1);
        pane.add(first_name, 1,0);
        pane.add(last_name,3,0);
        pane.add(address,1,1);
        pane.add(sex,3,1);
        pane.add(payment, 5, 1);

        pane.add(submit, 2,2);

        pane.getColumnConstraints().add(new ColumnConstraints(200));
        pane.setHgap(5);
        pane.setVgap(5);

        submit.setOnAction(e->{
            double pay = 0;

            if(isNumber(payment.getText())){
                pay = Double.parseDouble(payment.getText());
            }

            Customer customer = new Customer(first_name.getText(), last_name.getText(),
                    address.getText(), sex.getSelectionModel().getSelectedItem(), pay);

            controller.addData(customer, Display.CUSTOMERS);
        });
    }

    @Override
    public Pane display(){
        return pane;
    }

    public void displayOne(Customer customer){
        this.first_name.setText(customer.getFirst_name());
        this.last_name.setText(customer.getLast_name());
        this.address.setText(customer.getAddress());
    }

    private boolean isNumber(String s){

        char a;
        int c = 0;

        for(int i = 0; i < s.length(); i++){

            a = s.charAt(i);

            if(!Character.isDigit(a))
                c++;
        }

        return c <= 0 && s.length() != 0;
    }
}
