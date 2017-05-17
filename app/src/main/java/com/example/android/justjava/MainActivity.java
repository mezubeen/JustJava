package com.example.android.justjava;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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
        int price = calculatePrice();
        String priceMessage = createOrderSummary(price);
        // String priceMessage = "Total: $" + price ;
        //priceMessage = priceMessage + " \nThank you!";
        displayMessage(priceMessage);

//        displayPrice(quantity * 3);

    }


    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    //ORDER SUMMARY METHOD
    private String createOrderSummary(int price){
        String priceMessage =  "Name: Zubeen";
        priceMessage = priceMessage + "\nQuantity: " +quantity;
        priceMessage = priceMessage + "\nTotal: $" + price + " \nThank you!";
        return priceMessage;
    }

    public void increment(View view) {
        Log.i("EnterpriseActivity.java", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
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
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(message);


    }

}
