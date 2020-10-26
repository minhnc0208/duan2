package PRO2052_DATN.com.myapplication.activityuser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import PRO2052_DATN.com.myapplication.R;
import PRO2052_DATN.com.myapplication.adapter.RecyclerView_showBill;
import PRO2052_DATN.com.myapplication.dao.UserDao;

public class ShowBillDetailsActivity extends AppCompatActivity {
    RecyclerView recyclerhdcts;
    FirebaseDatabase database;
    DatabaseReference bill;
     ImageView imgbackcts;
    String id="";
    RecyclerView_showBill.RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bill_details);
        imgbackcts= findViewById(R.id.imgbackcts);
        recyclerhdcts = findViewById(R.id.recb);
        id= getIntent().getStringExtra("id");
        database= FirebaseDatabase.getInstance();
        bill= database.getReference("Bill");
        recyclerhdcts.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                false);
        recyclerhdcts.setLayoutManager(layoutManager);
        imgbackcts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        load();

    }

    // hàm load Bill Detail
    public void load(){
        adapter= new RecyclerView_showBill.RecyclerAdapter(this,UserDao.bill.getFoods());
        adapter.notifyDataSetChanged();
        recyclerhdcts.setAdapter(adapter);
    }
}
