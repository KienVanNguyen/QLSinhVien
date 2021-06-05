package kiennv.example.mob201_ps11892_asm.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import kiennv.example.mob201_ps11892_asm.Adapter.AdapterLT;
import kiennv.example.mob201_ps11892_asm.Adapter.AdapterWeb;
import kiennv.example.mob201_ps11892_asm.Adapter.AdapterUD;
import kiennv.example.mob201_ps11892_asm.Model.Coursee;
import kiennv.example.mob201_ps11892_asm.Model.UngDung;
import kiennv.example.mob201_ps11892_asm.Model.Web;
import kiennv.example.mob201_ps11892_asm.R;

public class LichHocActivity extends AppCompatActivity {
    Spinner spinner;
    ListView listView;
    List<Coursee> dsc = new ArrayList<>();
    ArrayList<Web> dsweb = new ArrayList<>();
    ArrayList<UngDung> dsud = new ArrayList<>();
    AdapterWeb apdaterLHW=null;
    AdapterUD adapterUD=null;
    AdapterLT adapterLT=null;
    String[] ngay = {"Lap Trinh Mobile","Lap Trinh Web","Lap Trinh Ung Dung"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lịch Học");
        setContentView(R.layout.activity_lich_hoc);
        spinner = findViewById(R.id.spiner);
        listView = findViewById(R.id.lvLH);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        //// spiner
        ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, ngay);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (i==0){
                    LapTrinh(listView);
                }
                if(i==1){
                    lichhocweb(listView);
                }

                if (i==2){
                    lichhocUD(listView);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return ;
    }

    public void LapTrinh(ListView listView){
        dsc.add(new Coursee("405","Lap Trinh Mobile","MOB201","LT15302"," Kien","9h45-11h45","22-10-2020"));
        dsc.add(new Coursee("405","Lap Trinh Mobile","MOB201","LT15302"," Kien","7h30-9h30","23-10-2020"));
        dsc.add(new Coursee("408","Thiet Ke Giao Dien Android","MOB202","LT15302"," Kien","9h45-11h45","23-10-2020"));
        dsc.add(new Coursee("508","Lap Trinh Mobile","MOB201","LT15302"," Kien","9h45-11h45","24-10-2020"));
        dsc.add(new Coursee("506","Lap Trinh Mobile","MOB201","LT15302"," Kien","9h45-11h45","25-10-2020"));
        dsc.add(new Coursee("405","Thiet Ke Giao Dien Android","MOB202","LT15302"," Kien","7h30-9h30","25-10-2020"));
        adapterLT=new AdapterLT(this,dsc);
        listView.setAdapter(adapterLT);

    }


    public void lichhocweb(ListView listView){
        dsweb.add(new Web("301-2","Web","Php112","WEB11303"," Kien","9h45-11h45","22-10-2020"));
        dsweb.add(new Web("305","Ky Nang Hoc Tap","KN002","WEB11303"," Kien","7h30-9h30","23-10-2020"));
        dsweb.add(new Web("301","HTML5-CSS3","WEB024","WEB11303"," Kien","9h45-11h45","23-10-2020"));
        dsweb.add(new Web("301-3","ENT","ENT1103","WEB11303"," Kien","9h45-11h45","24-10-2020"));
        dsweb.add(new Web("209","PHP","Php112","WEB11303"," Kien","9h45-11h45","25-10-2020"));
        dsweb.add(new Web("210","Ky Nang Hoc Tap","KN002","WEB11303"," Kien","7h30-9h30","25-10-2020"));
        apdaterLHW=new AdapterWeb(this,dsweb);
        listView.setAdapter(apdaterLHW);
    }
    public void lichhocUD(ListView listView){
        dsud.add(new UngDung("301-2","JAVA1","JV1","JaVa11303"," Kien","9h45-11h45","02-10-2020"));
        dsud.add(new UngDung("305","Ky Nang Hoc Tap","KN002","JaVa11303"," Kien","7h30-9h30","13-10-2020"));
        dsud.add(new UngDung("301","JAVA2","JV2","JaVa211303"," Kien","9h45-11h45","23-10-2020"));
        dsud.add(new UngDung("301-3","ENT","ENT1103","JaVa11303"," Kien","9h45-11h45","11-12-2020"));
        dsud.add(new UngDung("209","Co So Du Lieu","CDLD1123","JaVa11303"," Kien","9h45-11h45","20-12-2020"));
        dsud.add(new UngDung("210","Ky Nang Hoc Tap","KN002","JaVa11303"," Kien","7h30-9h30","27-12-2020"));
        adapterUD=new AdapterUD(this,dsud);
        listView.setAdapter(adapterUD);
    }

}