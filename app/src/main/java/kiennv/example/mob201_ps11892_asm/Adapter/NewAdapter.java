package kiennv.example.mob201_ps11892_asm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import kiennv.example.mob201_ps11892_asm.Model.News;
import kiennv.example.mob201_ps11892_asm.R;

public class NewAdapter extends ArrayAdapter<News> {

    public NewAdapter(Context context, int resource, List<News> items) {
        super(context, resource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.list_news, null);
        }
        News p = getItem(position);
        if (p != null) {
            // Anh xa + Gan gia tri
            TextView txtTitle = view.findViewById(R.id.tv_title);
            txtTitle.setText(p.title);
            TextView txtpubDate = view.findViewById(R.id.tv_pubDate);
            txtpubDate.setText(p.pubDate);
            ImageView iv_thumbnail = view.findViewById(R.id.iv_thumbnail);
            Picasso.with(getContext()).load((p.image)).into(iv_thumbnail);


        }
        return view;
    }

}