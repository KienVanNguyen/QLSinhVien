package kiennv.example.mob201_ps11892_asm.Activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import kiennv.example.mob201_ps11892_asm.Dao.DangKiHocDAO;
import kiennv.example.mob201_ps11892_asm.R;


public class DKHDetailActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{
    EditText edtMaSoSua, edtHoTenSua, edtNgaySinhSua, edtSoDTSua, edtEmailSua, edtTenMonSua;
    DangKiHocDAO dangKiHocDAO;
    String masosua, hotensua, tenmonsua ,ngaysinhsua, sodtsua, emailsua;
    ImageView ivDateSua;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dkh_detail);
        edtMaSoSua = findViewById(R.id.edtMaSoSua);
        edtHoTenSua = findViewById(R.id.edtHoTenSua);
        edtNgaySinhSua = findViewById(R.id.edtNgaySinhSua);
        edtSoDTSua = findViewById(R.id.edtPhoneSua);
        edtEmailSua = findViewById(R.id.edtEmailSua);
        edtTenMonSua = findViewById(R.id.edtTenMonSua);
        ivDateSua = findViewById(R.id.ivDateSua);



        dangKiHocDAO = new DangKiHocDAO(this);
        Intent in = getIntent();
        Bundle k = in.getExtras();

        masosua = k.getString("MADKH");
        hotensua = k.getString("HOTEN");
        tenmonsua = k.getString("TENMON");
        ngaysinhsua = k.getString("NGAYSINH");
        sodtsua = k.getString("PHONE");
        emailsua = k.getString("EMAIL");


        edtMaSoSua.setText(masosua);
        edtHoTenSua.setText(hotensua);
        edtTenMonSua.setText(tenmonsua);
        edtNgaySinhSua.setText(ngaysinhsua);
        edtSoDTSua.setText(sodtsua);
        edtEmailSua.setText(emailsua);

    }

    public void UpdateDKH(View view) {
        try {
            if (dangKiHocDAO.updateDangKiHoc(masosua, edtMaSoSua.getText().toString(), edtHoTenSua.getText().toString(),
                    edtTenMonSua.getText().toString(), edtNgaySinhSua.getText().toString(), edtSoDTSua.getText().toString(),
                    edtEmailSua.getText().toString()) >0){
                Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Lưu thất bại",
                        Toast.LENGTH_SHORT).show();
            }

        } catch (Exception ex) {

            if (edtMaSoSua.getText().length() == 0 || edtHoTenSua.getText().length() == 0 || edtTenMonSua.getText().length() == 0
                    || edtSoDTSua.getText().length() == 0 || edtNgaySinhSua.getText().length() == 0
                    || edtEmailSua.getText().length() == 0 ) {
                Toast.makeText(getApplicationContext(), "Bạn chưa nhập đầy đủ thông tin ", Toast.LENGTH_SHORT).show();
            }
        }finish();
    }

    public void quaysua(View view) {
        finish();
    }

    //ngay
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
        setDate(cal);
    }
    private void setDate(final Calendar calendar) {
        edtNgaySinhSua.setText(sdf.format(calendar.getTime()));
    }

    public void datePickerSua(View view) {
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

