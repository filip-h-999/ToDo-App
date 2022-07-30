package com.example.versuch5;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.graphics.Color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {

    boolean clicked = false;
    Animation fabOpen, fabClosed;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.black));
        changeTextColor();

        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        FloatingActionButton fab2 = findViewById(R.id.floatingActionButton2);
        FloatingActionButton fab3 = findViewById(R.id.floatingActionButton3);
        FloatingActionButton fab4 = findViewById(R.id.floatingActionButton4);
        FloatingActionButton fab5 = findViewById(R.id.floatingActionButton5);
        FloatingActionButton fab6 = findViewById(R.id.floatingActionButton6);
        FloatingActionButton fab7 = findViewById(R.id.floatingActionButton7);
        FloatingActionButton fab8 = findViewById(R.id.floatingActionButton8);

        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClosed = AnimationUtils.loadAnimation(this,R.anim.fab_close);

        fab.setOnClickListener(v -> animationFab());
        setFabListener(fab2,R.id.newTaskText,R.id.checkBox);
        setFabListener(fab3,R.id.newTaskText2,R.id.checkBox2);
        setFabListener(fab4,R.id.newTaskText3,R.id.checkBox3);
        setFabListener(fab5,R.id.newTaskText4,R.id.checkBox4);
        setFabListener(fab6,R.id.newTaskText5,R.id.checkBox5);
        setFabListener(fab7,R.id.newTaskText6,R.id.checkBox6);
        setFabListener(fab8,R.id.newTaskText7,R.id.checkBox7);
    }

    private void setFabListener(FloatingActionButton f, int e, int x){
        f.setOnClickListener(v -> {
            ((EditText)findViewById(e)).setText("");
            ((CheckBox)findViewById(x)).setChecked(false);
            ((EditText)findViewById(e)).setTextColor(Color.BLACK);
        });
    }

    private void animationFab(){
        FloatingActionButton fab2 = findViewById(R.id.floatingActionButton2);
        FloatingActionButton fab3 = findViewById(R.id.floatingActionButton3);
        FloatingActionButton fab4 = findViewById(R.id.floatingActionButton4);
        FloatingActionButton fab5 = findViewById(R.id.floatingActionButton5);
        FloatingActionButton fab6 = findViewById(R.id.floatingActionButton6);
        FloatingActionButton fab7 = findViewById(R.id.floatingActionButton7);
        FloatingActionButton fab8 = findViewById(R.id.floatingActionButton8);

        if (clicked){
            fab2.startAnimation(fabClosed);
            fab3.startAnimation(fabClosed);
            fab4.startAnimation(fabClosed);
            fab5.startAnimation(fabClosed);
            fab6.startAnimation(fabClosed);
            fab7.startAnimation(fabClosed);
            fab8.startAnimation(fabClosed);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            fab5.setClickable(false);
            fab6.setClickable(false);
            fab7.setClickable(false);
            fab8.setClickable(false);
            clicked = false;
        }else{
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            fab4.startAnimation(fabOpen);
            fab5.startAnimation(fabOpen);
            fab6.startAnimation(fabOpen);
            fab7.startAnimation(fabOpen);
            fab8.startAnimation(fabOpen);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            fab5.setClickable(true);
            fab6.setClickable(true);
            fab7.setClickable(true);
            fab8.setClickable(true);
            clicked = true;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }

    private void loadData() {
        SharedPreferences prefs = getSharedPreferences("Data",MODE_PRIVATE);
        String task1 = prefs.getString("task1", "");
        ((EditText)findViewById(R.id.newTaskText)).setText(task1);
        String task2 = prefs.getString("task2","");
        ((EditText)findViewById(R.id.newTaskText2)).setText(task2);
        String task3 = prefs.getString("task3", "");
        ((EditText)findViewById(R.id.newTaskText3)).setText(task3);
        String task4 = prefs.getString("task4", "");
        ((EditText)findViewById(R.id.newTaskText4)).setText(task4);
        String task5 = prefs.getString("task5", "");
        ((EditText)findViewById(R.id.newTaskText5)).setText(task5);
        String task6 = prefs.getString("task6", "");
        ((EditText)findViewById(R.id.newTaskText6)).setText(task6);
        String task7 = prefs.getString("task7", "");
        ((EditText)findViewById(R.id.newTaskText7)).setText(task7);

        boolean check1 = prefs.getBoolean("check1", false);
        ((CheckBox)findViewById(R.id.checkBox)).setChecked(check1);
        boolean check2 = prefs.getBoolean("check2", false);
        ((CheckBox)findViewById(R.id.checkBox2)).setChecked(check2);
        boolean check3 = prefs.getBoolean("check3", false);
        ((CheckBox)findViewById(R.id.checkBox3)).setChecked(check3);
        boolean check4 = prefs.getBoolean("check4", false);
        ((CheckBox)findViewById(R.id.checkBox4)).setChecked(check4);
        boolean check5 = prefs.getBoolean("check5", false);
        ((CheckBox)findViewById(R.id.checkBox5)).setChecked(check5);
        boolean check6 = prefs.getBoolean("check6", false);
        ((CheckBox)findViewById(R.id.checkBox6)).setChecked(check6);
        boolean check7 = prefs.getBoolean("check7", false);
        ((CheckBox)findViewById(R.id.checkBox7)).setChecked(check7);
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public void saveData(){
        SharedPreferences prefs = getSharedPreferences("Data", MODE_PRIVATE);

        String task1 =  ((EditText)findViewById(R.id.newTaskText)).getText().toString();
        String task2 =  ((EditText)findViewById(R.id.newTaskText2)).getText().toString();
        String task3 =  ((EditText)findViewById(R.id.newTaskText3)).getText().toString();
        String task4 =  ((EditText)findViewById(R.id.newTaskText4)).getText().toString();
        String task5 =  ((EditText)findViewById(R.id.newTaskText5)).getText().toString();
        String task6 =  ((EditText)findViewById(R.id.newTaskText6)).getText().toString();
        String task7 =  ((EditText)findViewById(R.id.newTaskText7)).getText().toString();

        boolean box1 = ((CheckBox)findViewById(R.id.checkBox)).isChecked();
        boolean box2 = ((CheckBox)findViewById(R.id.checkBox2)).isChecked();
        boolean box3 = ((CheckBox)findViewById(R.id.checkBox3)).isChecked();
        boolean box4 = ((CheckBox)findViewById(R.id.checkBox4)).isChecked();
        boolean box5 = ((CheckBox)findViewById(R.id.checkBox5)).isChecked();
        boolean box6 = ((CheckBox)findViewById(R.id.checkBox6)).isChecked();
        boolean box7 = ((CheckBox)findViewById(R.id.checkBox7)).isChecked();

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("check1",box1);
        editor.putBoolean("check2",box2);
        editor.putBoolean("check3",box3);
        editor.putBoolean("check4",box4);
        editor.putBoolean("check5",box5);
        editor.putBoolean("check6",box6);
        editor.putBoolean("check7",box7);

        editor.putString("task1",task1);
        editor.putString("task2",task2);
        editor.putString("task3",task3);
        editor.putString("task4",task4);
        editor.putString("task5",task5);
        editor.putString("task6",task6);
        editor.putString("task7",task7);
        editor.apply();
    }

    private void changeTextColor(){
        setCheckBoxListener(findViewById(R.id.checkBox),findViewById(R.id.newTaskText));
        setCheckBoxListener(findViewById(R.id.checkBox2),findViewById(R.id.newTaskText2));
        setCheckBoxListener(findViewById(R.id.checkBox3),findViewById(R.id.newTaskText3));
        setCheckBoxListener(findViewById(R.id.checkBox4),findViewById(R.id.newTaskText4));
        setCheckBoxListener(findViewById(R.id.checkBox5),findViewById(R.id.newTaskText5));
        setCheckBoxListener(findViewById(R.id.checkBox6),findViewById(R.id.newTaskText6));
        setCheckBoxListener(findViewById(R.id.checkBox7),findViewById(R.id.newTaskText7));
    }

    private void setCheckBoxListener(CheckBox c, EditText t){
        c.setOnCheckedChangeListener((v, checked) -> {
            if(checked){
                t.setTextColor(Color.GREEN);
            }else{
                t.setTextColor(Color.BLACK);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onStop() {
        saveData();
        super.onStop();
    }
}
