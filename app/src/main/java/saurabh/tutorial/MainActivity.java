package saurabh.tutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    String [] Country_names;


    TextView textView;
    ArrayList<String> selection = new ArrayList<String>();

    Switch aSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.country);
        Country_names = getResources().getStringArray(R.array.country_names);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Country_names);
        autoCompleteTextView.setAdapter(adapter);

        textView = (TextView) findViewById(R.id.final_result);
        textView.setVisibility(View.INVISIBLE);

        aSwitch = (Switch) findViewById(R.id.switchon);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textView.setText("Wifi On");

                }
                else{
                    textView.setText("Wifi Off");
                    //textView.setText(View.VISIBLE);
                }
                textView.setVisibility(View.VISIBLE);
            }
        });
    }
    public void selectItem(View view){
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
            case R.id.fruit_apple :
                if(checked){
                    selection.add("Apple");
                }
                else{
                    selection.remove("Apple");
                }
                break;
            case R.id.fruit_orange :
                if(checked){
                    selection.add("Orange");
                }
                else{
                    selection.remove("Orange");
                }
                break;
            case R.id.fruit_grapes :
                if(checked){
                    selection.add("Grapes");
                }
                else{
                    selection.remove("Grapes");
                }
                break;
        }
    }

    public void finalSelection(View view){
        String finalSelected = "";
        for(String selections:selection){
            finalSelected += selections+"\n";
        }
        textView.setText(finalSelected);
        textView.setVisibility(View.VISIBLE);
    }

    public void selectRadio(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radio_apple:
                Toast.makeText(this,"Apple selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_grapes:
                Toast.makeText(this,"Grapes selected",Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_orange:
                Toast.makeText(this,"Orange selected",Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public void changeMode(View view){
        boolean checked = ((ToggleButton) view).isChecked();
        if(checked){
            Toast.makeText(this,"Vibrate On",Toast.LENGTH_SHORT).show();
        }
    }

    public void newIntent(View view){
        Intent intent = new Intent(getBaseContext(),Main2Activity.class);
        startActivity(intent);
    }
}
