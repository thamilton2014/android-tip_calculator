package com.example.thamilton.tip_calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class MainActivity extends Activity implements OnSeekBarChangeListener {

    private SeekBar tip_seekbar;
    private SeekBar dollar_seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tip_seekbar = (SeekBar) findViewById(R.id.tip_seekbar);
        this.dollar_seekbar = (SeekBar) findViewById(R.id.dollar_seekbar);

        this.tip_seekbar.setOnSeekBarChangeListener(this);
        this.dollar_seekbar.setOnSeekBarChangeListener(this);

        this.tip_seekbar.setMax(50);
        this.dollar_seekbar.setMax(255);

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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        TextView tip_value = (TextView) findViewById(R.id.tip_value);
        TextView dollar_value = (TextView) findViewById(R.id.dollar_value);
//
        tip_value.setText(Integer.toString(this.tip_seekbar.getProgress()));
        dollar_value.setText(Integer.toString(this.dollar_seekbar.getProgress()));

        //this.tip_seekbar.getProgress() * this.dollar_seekbar.getProgress()
        TextView amount_value = (TextView) findViewById(R.id.amount_value);
        double tip = this.tip_seekbar.getProgress() * this.dollar_seekbar.getProgress();
        double amount = tip / 100;
        amount_value.setText(amount + "");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
