package com.example.android.justjava;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is called when the order button is clicked.

    public void submitOrder(View view) {
        // FOR WHIPPED CREAM TOPPING
        CheckBox whippedcreamcheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        Boolean hasWhippedCream = whippedcreamcheckbox.isChecked();
        // FOR CHOCOLATE TOPPING
        CheckBox chocolateTopping = (CheckBox) findViewById(R.id.chocolate_topping_checkbox);
        Boolean hasChocolateTopping = chocolateTopping.isChecked();

        //FOR NAME
        EditText name = (EditText) findViewById(R.id.name);
        String name_string = name.getText().toString();

        // Log.v("MainActivity", "has whippedcream "+hasWhippedCream);

        int price = calculatePrice(hasWhippedCream, hasChocolateTopping);
        String priceMessage = createOrderSummary(name_string, price, hasWhippedCream, hasChocolateTopping);
        // String priceMessage = "Total: $" + price ;
        //priceMessage = priceMessage + " \nThank you!";

       // displayMessage(priceMessage);
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto","abc@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));



    }


    private int calculatePrice(Boolean addWhippedCream, Boolean addChocolateToping) {
        int price = 5;

        if(addWhippedCream){
            price = price + 1;
        }

        if(addChocolateToping){
            price = price +2;
        }

        return price * quantity;
    }

    //ORDER SUMMARY METHOD
    private String createOrderSummary(String name, int price, boolean addWhippedTopping, boolean addChocolateTopping) {
        String priceMessage = "Name: " + name;
        priceMessage = priceMessage + "\nAdd Whipped Cream Topping? " + addWhippedTopping;
        priceMessage = priceMessage + "\nAdd Chocolate Topping? " + addChocolateTopping;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price + " \nThank you!";
        return priceMessage;
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if (quantity > (1)) {
            quantity = quantity - 1;
            displayQuantity(quantity);

        } else {
            Context context = getApplicationContext();
            CharSequence text = "Quantity can't be less than 1!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantityNumber) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantityNumber);

    }

    /**
     * This method displays the given price on the screen.
     */
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//    }

    /**
     * This method displays the given text on the screen.
     */
//    private void displayMessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
//        priceTextView.setText(message);
//
//
//    }

}
