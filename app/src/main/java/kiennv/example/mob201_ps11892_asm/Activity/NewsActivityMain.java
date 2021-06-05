package kiennv.example.mob201_ps11892_asm.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import kiennv.example.mob201_ps11892_asm.Adapter.NewAdapter;
import kiennv.example.mob201_ps11892_asm.Model.News;
import kiennv.example.mob201_ps11892_asm.R;

public class NewsActivityMain extends AppCompatActivity {
    ListView lv1;
    NewAdapter customAdapter;
    ArrayList<News> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("News");
        setContentView(R.layout.activity_news);
        lv1 = findViewById(R.id.lvNews);
        arrayList = new ArrayList<>();

        new MyTask().execute("https://vnexpress.net/rss/giao-duc.rss");

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NewsActivityMain.this, NewsActivity2.class);
                intent.putExtra("Link", arrayList.get(i).link);
                startActivity(intent);
            }
        });

    }

    class MyTask extends AsyncTask<String,Void,String> {
        @Override
        protected String doInBackground(String... strings) {
            StringBuffer content=new StringBuffer();
            //kiem tra url va doc du lieu
            try {
                URL url=new URL(strings[0]);
                InputStreamReader inputStreamReader=new InputStreamReader(url.openConnection().getInputStream());

                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String line="";
                while ((line=bufferedReader.readLine())!=null){
                    content.append(line);
                }

                // dong diu lieu
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return  content.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            NodeList nodeListdescription = document.getElementsByTagName("description");
            String title = "";
            String link = "";
            String hinhanh= "";
            String pubDate= "";
            for (int i=0; i<nodeList.getLength();i++){
                String cdate = nodeListdescription.item(i+1).getTextContent();
                Pattern pattern = Pattern.compile("<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>");
                Matcher matcher = pattern.matcher(cdate);
                if (matcher.find()){
                    hinhanh = matcher.group(1);
                }
                Element element = (Element) nodeList.item(i);
                title = parser.getValue(element,"title");
                link = parser.getValue(element,"link");
                pubDate = parser.getValue(element,"pubDate");
                arrayList.add(new News(title,link,hinhanh,pubDate));

                customAdapter = new NewAdapter(NewsActivityMain.this,android.R.layout.simple_list_item_1,arrayList);
                lv1.setAdapter(customAdapter);

            }
            super.onPostExecute(s);
        }
    }




}