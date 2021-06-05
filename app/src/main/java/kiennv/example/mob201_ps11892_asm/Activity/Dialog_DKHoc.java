package kiennv.example.mob201_ps11892_asm.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import kiennv.example.mob201_ps11892_asm.Dao.DangKiHocDAO;
import kiennv.example.mob201_ps11892_asm.Model.DangKiHoc;
import kiennv.example.mob201_ps11892_asm.R;

public class Dialog_DKHoc extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    DangKiHocDAO dangKiHocDAO;
    Button btnCancelND;
    ImageView ivDate;
    EditText edtMaSo,edtHoTen,edtNgaySinh,edtPhone,edtEmail,edtTenMon;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("ĐĂNG KÍ HỌC");
        setContentView(R.layout.dialog_dkhoc);
        edtMaSo = findViewById(R.id.edtMaSo);
        edtHoTen = findViewById(R.id.edtHoTen);
        edtNgaySinh = findViewById(R.id.edtNgaySinh);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtTenMon = findViewById(R.id.edtTenMon);
        ivDate = findViewById(R.id.ivDate);
        btnCancelND = findViewById(R.id.btnCancelND);


    }
    public void cancel(View view) {
        finish();
    }
    public void AddDKH(View view){
        dangKiHocDAO = new DangKiHocDAO(Dialog_DKHoc.this);
        DangKiHoc dangKiHoc = new DangKiHoc(edtMaSo.getText().toString(), edtHoTen.getText().toString(),edtTenMon.getText().toString(),
                edtNgaySinh.getText().toString(),edtPhone.getText().toString(), edtEmail.getText().toString() );
        try {
            if (validateForm() > 0) {
                if (dangKiHocDAO.insertDangKiHoc(dangKiHoc) > 0) {
                    onBackPressed();
                    Toast.makeText(getApplicationContext(), "Thêm thành công!!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Thêm thất bại!!!", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception ex) {
            Log.e("Lỗi:", ex.toString());
        }

    }
    public int validateForm() {
        int check = 1;
        if (edtMaSo.getText().length() == 0 || edtHoTen.getText().length() == 0 || edtTenMon.getText().length() == 0
                || edtNgaySinh.getText().length() == 0 || edtPhone.getText().length() == 0 || edtEmail.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            check = -1;
        }
        return check;
    }
//date
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
        setDate(cal);
    }
    private void setDate(final Calendar calendar) {
        edtNgaySinh.setText(sdf.format(calendar.getTime()));
    }

    public void datePicker(View view) {
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(), "date");
    }

    public static class DatePickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
    }
}