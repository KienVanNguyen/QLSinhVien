package kiennv.example.mob201_ps11892_asm.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

import kiennv.example.mob201_ps11892_asm.Activity.LichHocActivity;
import kiennv.example.mob201_ps11892_asm.Model.UngDung;
import kiennv.example.mob201_ps11892_asm.R;

public class AdapterUD extends BaseAdapter {
    public static List<UngDung> arrNguoiDung;
    private Context context;
    private LayoutInflater inflater;
    public AdapterUD(LichHocActivity context, List<UngDung> arrNguoiDung){
        this.arrNguoiDung = arrNguoiDung;
        this.context = context;
        this.inflater =
                (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
      ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.itemcoursee, null);
            holder.ngay = (TextView) view.findViewById(R.id.Ngay);
            holder.phong = (TextView) view.findViewById(R.id.Phong);
            holder.giangduong = (TextView) view.findViewById(R.id.GiangDuong);
            holder.mamon = (TextView) view.findViewById(R.id.MaMon);
            holder.lop = (TextView) view.findViewById(R.id.Lop);
            holder.giangvien = (TextView) view.findViewById(R.id.GiangVien);
            holder.thoigian = (TextView) view.findViewById(R.id.SlotthoiGiang);
            view.setTag(holder);
        }
        else
            holder = (ViewHolder) view.getTag();
        UngDung _entry = (UngDung) arrNguoiDung.get(i);
        holder.ngay.setText(_entry.getmNgay());
        holder.phong.setText("" + _entry.getmPhong());
        holder.giangduong.setText("" + _entry.getmGiangDuong());
        holder.mamon.setText("" + _entry.getmMaMon());
        holder.lop.setText("" + _entry.getmLop());
        holder.giangvien.setText("" + _entry.getMgiangVien());
        holder.thoigian.setText("" + _entry.getmThoiGian());
        notifyDataSetChanged();


        return view;

    }

    public static class ViewHolder {
        TextView ngay;
        TextView phong;
        TextView giangduong;
        TextView mamon;
        TextView lop;
        TextView giangvien;
        TextView thoigian;
    }
    @Override
    public void notifyDataSetChanged(){
        super.notifyDataSetChanged();
    }


}