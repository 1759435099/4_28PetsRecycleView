package com.example.a4_17recycleview;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    private DrawerLayout mDrawerLayout;

    private Fruit[] fruits = {new Fruit("apple",R.drawable.ic_launcher_background),
            new Fruit("apple",R.drawable.ic_launcher_background),
            new Fruit("apple",R.drawable.ic_launcher_background),
            new Fruit("apple",R.drawable.ic_launcher_background)};

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();

        RecyclerView recyclerView = findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits(){
//        for (int i = 0; i < 2; i++) {
//            Fruit apple = new Fruit("apple",R.drawable.ic_launcher_background);
//            fruitList.add(apple);
//            Fruit apple1 = new Fruit("apple",R.drawable.ic_launcher_background);
//            fruitList.add(apple1);
//            Fruit apple2 = new Fruit("apple",R.drawable.ic_launcher_background);
//            fruitList.add(apple2);
//            Fruit apple3 = new Fruit("apple",R.drawable.ic_launcher_background);
//            fruitList.add(apple3);
//        }
        fruitList.clear();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }
}