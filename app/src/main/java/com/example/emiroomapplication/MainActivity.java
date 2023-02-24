package com.example.emiroomapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Entity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    EditText name1,amount1,rate1,month1,year1;
    Button cal1,save1,fetch1;
    TextView emi2,totalinterest2,totalpayment2,timestamp2;
    static EmiDatabase database;
    FAdapter adapter;
    EmiEntity entity;
    List<EmiEntity>list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1=findViewById(R.id.name);
        amount1=findViewById(R.id.amount);
        rate1=findViewById(R.id.rate);
        year1=findViewById(R.id.year);
        month1=findViewById(R.id.month);
        emi2=findViewById(R.id.emi);
        timestamp2=findViewById(R.id.timestamp);
        totalpayment2=findViewById(R.id.totalpayment);
        totalinterest2=findViewById(R.id.totalinterest);
        save1=findViewById(R.id.save);
        fetch1=findViewById(R.id.fetch);
         cal1=findViewById(R.id.cal);

         cal1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 double PrincipleAmount1 =Integer.parseInt(amount1.getText().toString());
                 double Interest1 =Integer.parseInt(rate1.getText().toString());
                 int Month1 =Integer.parseInt(month1.getText().toString());
                 int Year1 =Integer.parseInt(year1.getText().toString());
                 int yearExchange =(Year1*12)+Month1;

                 double principle = PrincipleAmount1*(Interest1/100);
                 double power = Math.pow(Interest1/100+1,yearExchange);
                 double sum = principle/(1-(1/power));

                 double TotalInterest = sum * yearExchange - PrincipleAmount1;
                 double TotalPayment1 = PrincipleAmount1 + TotalInterest;

                 emi2.setText(String.valueOf(sum));
                 totalinterest2.setText(String.valueOf(TotalInterest));
                 totalpayment2.setText(String.valueOf(TotalPayment1));
                 Date dateCurrent = Calendar.getInstance().getTime();
                 timestamp2.setText(dateCurrent.toString());


             }
         });
         save1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 savedata();
             }
         });
         fetch1.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 startActivity(new Intent(getApplicationContext(),recycleractivity.class));

             }
         });
database= Room.databaseBuilder(this,EmiDatabase.class,"rdb").allowMainThreadQueries().build();
    }
public void savedata(){
    String sdate = timestamp2.getText().toString();
    String sname = name1.getText().toString();
    String semi= emi2.getText().toString();
    String samount=amount1.getText().toString();
    String stotalamount=totalpayment2.getText().toString();
    String sinterest=totalinterest2.getText().toString();
    entity=new EmiEntity();
    entity.setDate(sdate);
    entity.setName(sname);
    entity.setAmount(samount);
    entity.setTotalamount(stotalamount);
    entity.setEmi(semi);
    entity.setInterest(sinterest);
    database.emiDao().insert(entity);
    Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();

}

}