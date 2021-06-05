package kiennv.example.mob201_ps11892_asm.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kiennv.example.mob201_ps11892_asm.Activity.DKHDetailActivity;
import kiennv.example.mob201_ps11892_asm.Dao.DangKiHocDAO;
import kiennv.example.mob201_ps11892_asm.Model.DangKiHoc;
import kiennv.example.mob201_ps11892_asm.R;


public class DangKiHocAdapter extends RecyclerView.Adapter<DangKiHocAdapter.ViewHolder> {
    public Context   context;
    public LayoutInflater inflater;
    List<DangKiHoc> arrDangKiHoc;
    DangKiHocDAO dangKiHocDAO;


    public DangKiHocAdapter(Activity context, List<DangKiHoc> arrayDKH) {
        super();
        this.context = context;
        this.arrDangKiHoc = arrayDKH;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        dangKiHocDAO = new DangKiHocDAO(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dkh, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,final int position) {
        final DangKiHoc dangKiHoc = (DangKiHoc) arrDangKiHoc.get(position);
        holder.txtName.setText("Name: " + dangKiHoc.getHoTen());
        holder.txtMon.setText("Môn: "+ dangKiHoc.getTenMon());
        holder.txtNgay.setText("Ngày: "+ dangKiHoc.getNgaySinh());

        //doi anh
        if (position % 3 == 0) {
            holder.img.setImageResource(R.drawable.student);
        } else if (position % 3 == 1) {
            holder.img.setImageResource(R.drawable.student1);
        } else if (position % 3 == 2) {
            holder.img.setImageResource(R.drawable.student2);
        } else if (position % 3 == 3) {
            holder.img.setImageResource(R.drawable.student);
        }
        holder.setOnItemClick(new ItemClick() {
            @Override
            public void setOnClick(int position) {
                Intent intent = new Intent(context, DKHDetailActivity.class);
                Bundle b = new Bundle();
                b.putString("MADKH", dangKiHoc.getMaDKH());
                b.putString("HOTEN", dangKiHoc.getHoTen());
                b.putString("TENMON", dangKiHoc.getTenMon());
                b.putString("NGAYSINH", dangKiHoc.getNgaySinh());
                b.putString("PHONE", dangKiHoc.getPhone());
                b.putString("EMAIL", dangKiHoc.getEmail());
                intent.putExtras(b);
                context.startActivity(intent);
            }


        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                builder1.setTitle("Delete Student!");
                builder1.setIcon(R.drawable.warn);
                builder1.setMessage("Bạn có chắc chắn muốn xóa " + arrDangKiHoc.get(position).getHoTen());
                builder1.setCancelable(true);
                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dangKiHocDAO = new DangKiHocDAO(context);
                                dangKiHocDAO.deleteDangKiHocByID(arrDangKiHoc.get(position).getMaDKH());
                                Toast.makeText(context, "Bạn đã xóa " + arrDangKiHoc.get(position).getHoTen(), Toast.LENGTH_SHORT).show();
                                arrDangKiHoc.remove(position);
                                notifyDataSetChanged();
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrDangKiHoc.size();
    }
    public void changeDataset(List<DangKiHoc> items) {
        this.arrDangKiHoc = items;
        notifyDataSetChanged();
    }

    interface ItemClick{
        void setOnClick(int position);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;
        TextView txtName;
        TextView txtMon;
        TextView txtNgay;
        ImageView imgDelete;
        DangKiHocAdapter.ItemClick itemClick;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.tvName);
            txtMon = itemView.findViewById(R.id.tvtenMon);
            txtNgay = itemView.findViewById(R.id.tvNgay);
            imgDelete = itemView.findViewById(R.id.ivDelete);
            img = itemView.findViewById(R.id.ivDKH);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            itemClick.setOnClick(getAdapterPosition());
        }
        public void setOnItemClick(DangKiHocAdapter.ItemClick itemClick) {
            this.itemClick = itemClick;
        }
    }
}
