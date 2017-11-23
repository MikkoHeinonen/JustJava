package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MyActivity";
    int quantity = 2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button increaseButton = findViewById(R.id.increase_button);
        Button decreaseButton = findViewById(R.id.decrease_button);
        Button orderButton = findViewById(R.id.order_button);

        increaseButton.setOnClickListener(this);
        decreaseButton.setOnClickListener(this);
        orderButton.setOnClickListener(this);

        display(quantity);
    }

    @Override
    public void onClick(View v){

        switch (v.getId()){

            case R.id.increase_button:
                increaseOrder(v);
                break;

            case R.id.decrease_button:
                decreaseOrder(v);
                break;

            case R.id.order_button:
                submitOrder(v);
                break;
        }
    }

    private void submitOrder(View view) {
        displayPrice(quantity * 5);

    }

    private void increaseOrder(View view) {
        quantity = quantity + 1;
        display(quantity);
        Log.i(TAG, "increaseOrder: " + quantity);
    }

    private void decreaseOrder(View view) {
        quantity = quantity - 1;
        display(quantity);
        Log.i(TAG, "decreaseOrder: " + quantity);
    }

    private void display(int number) {

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    private void displayPrice(int number) {

        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);

        NumberFormat temppi = NumberFormat.getCurrencyInstance();
        temppi.setMaximumFractionDigits(0);
        temppi.getCurrency();
        String price = temppi.format(number);

        String final_price= "Total: " + price + "\nThank you!";
        priceTextView.setText(final_price);

    }

}
