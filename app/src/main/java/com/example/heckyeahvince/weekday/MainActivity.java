package com.example.heckyeahvince.weekday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Integer day;
    public Integer month;
    public Integer year;
    public int a, b, c, d, e, f, month_adj, D, year_y, year_c;
    private String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getInputValues(){
        EditText et_day = (EditText) findViewById(R.id.edittextday);
        EditText et_month = (EditText) findViewById(R.id.edittextmonth);
        EditText et_year = (EditText) findViewById(R.id.edittextyear);

        day = Integer.parseInt(et_day.getText().toString());
        month = Integer.parseInt(et_month.getText().toString());
        year = Integer.parseInt(et_year.getText().toString());
    }

    private void computeDay(){
        month_adj = 0;

        if (month == 1)
            month_adj = 13;
        else if (month == 2)
            month_adj = 14;
        else
            month_adj = month;

        year_c = year / 100;
        year_y = year % 100;

        a = day;
        b = 26 * (month_adj + 1) / 10;
        c = year_y;
        d = year_y / 4;
        e = year_c / 4;
        f = 5 * year_c;

        D = (a + b + c + d + e + f) % 7;
    }

    private void printDay(){
        String day_text;
        switch(D) {
            case 0:
                day_text = month + "/" + day + "/" + (year % 100) + " is Saturday!";
                break;
            case 1:
                day_text = month + "/" + day + "/" + (year % 100) + " is Sunday!";
                break;
            case 2:
                day_text = month + "/" + day + "/" + (year % 100) + " is Monday!";
                break;
            case 3:
                day_text = month + "/" + day + "/" + (year % 100) + " is Tuesday!";
                break;
            case 4:
                day_text = month + "/" + day + "/" + (year % 100) + " is Wednesday!";
                break;
            case 5:
                day_text = month + "/" + day + "/" + (year % 100) + " is Thursday!";
                break;
            case 6:
                day_text = month + "/" + day + "/" + (year % 100) + " is Friday!";
                break;
            default:
                day_text = "Invalid day!";
        }

        TextView tv_out = (TextView) findViewById(R.id.displayDay);
        tv_out.setText(day_text);
    }


        public void onClickCompute(View v){
            getInputValues();
            computeDay();
            printDay();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }