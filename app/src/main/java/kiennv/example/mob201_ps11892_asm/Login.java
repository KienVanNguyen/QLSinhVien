package kiennv.example.mob201_ps11892_asm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class Login extends FragmentActivity {
    Button btnLogin, loginButton;
    EditText edtUser, edtPass;
    CheckBox chk;
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        edtUser = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPass);
        chk = findViewById(R.id.chk);

        //facebook
        loginButton = findViewById(R.id.login_button);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        ((LoginButton) loginButton).setReadPermissions(Arrays.asList("email"));


        //facebook
        ((LoginButton) loginButton).registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                startActivity(intent);
                Toast.makeText(Login.this,"Đăng nhập bằng Facebook thành công",Toast.LENGTH_LONG).show();
                getFbInfo();
            }

            @Override
            public void onCancel() {
                finish();
            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(Login.this,"Error",Toast.LENGTH_LONG).show();
            }
        });

        //get KEYHASH
//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "kiennv.example.mob201_ps11892_asm",
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//
//        } catch (NoSuchAlgorithmException e) {
//
//        }

///Login admin
        pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = pref.edit();
        //lay user va pass trong SharedPreferences
        edtUser.setText(pref.getString("user",""));
        edtPass.setText(pref.getString("pass",""));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chk.isChecked()){
                    // ghi user va pass vao SharedPreferences
                    editor.putString("user",edtUser.getText().toString());
                    editor.putString("pass",edtPass.getText().toString());
                    editor.apply();
                }
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                if (edtUser.length() == 0) {
                    Toast.makeText(Login.this, "Vui Lòng Nhập User!", Toast.LENGTH_SHORT).show();
                    edtUser.requestFocus();
                    return;
                } else if (edtPass.length() == 0){
                    Toast.makeText(Login.this, "Vui Lòng Nhập Password!", Toast.LENGTH_SHORT).show();
                    edtPass.requestFocus();
                    return;
                }
                if (user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) {
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(Login.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Login.this, "Ban da nhap sai User hoac Pass, Vui long nhap lai!", Toast.LENGTH_LONG).show();
                }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    private void getFbInfo() {
        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(),
                    new GraphRequest.GraphJSONObjectCallback() {
                        @Override
                        public void onCompleted(final JSONObject me, GraphResponse response) {
                            if (me != null) {
                                Log.i("Login: ", me.optString("name"));
                                Log.i("ID: ", me.optString("id"));

                                Toast.makeText(Login.this, "Name: " + me.optString("name"), Toast.LENGTH_SHORT).show();
                                Toast.makeText(Login.this, "ID: " + me.optString("id"), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,link");
            request.setParameters(parameters);
            request.executeAsync();
        }
    }
}