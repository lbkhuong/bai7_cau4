package com.example.bai7_cau4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DataSource dataSource;
    ChiTieuAdapter chiTieuAdapter;
    List<ChiTieuCaNhan> chiTieuCaNhanList;
    ListView listViewChiTieu;
    Button btnThem, btnSua, btnXoa;
    EditText edtNoiDung, edtSoTien;
    Long tongTien;
    TextView txtTongTien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        edtNoiDung = findViewById(R.id.edtNoiDung);
        edtSoTien = findViewById((R.id.edtSoTien));
        txtTongTien = findViewById(R.id.txtTongChiTieu);
        dataSource = new DataSource(this);
        dataSource.open();
        chiTieuCaNhanList = dataSource.getAllChiTieu();
        dataSource.close();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ChiTieuCaNhan> chitieus =  btnThem_click(chiTieuCaNhanList);
                fillDataToLV(chitieus);
                resetTextBox();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    public void fillDataToLV(List<ChiTieuCaNhan> chiTieuCaNhanList){
        if (chiTieuCaNhanList != null) {
            chiTieuAdapter = new ChiTieuAdapter(this, chiTieuCaNhanList);
            listViewChiTieu.setAdapter(chiTieuAdapter);
        }else {
            Toast.makeText(this, "Du Lieu Trong", Toast.LENGTH_LONG).show();
        }
    }
    public List<ChiTieuCaNhan> btnThem_click(List<ChiTieuCaNhan> chiTieuCaNhanList){
        dataSource = new DataSource(this);
        dataSource.open();
        if (edtNoiDung.getText().toString().equals("") || edtSoTien.getText().toString().equals("")){
            Toast.makeText(this, "Vui Long Nhap Vao ND va So Tien", Toast.LENGTH_LONG).show();
        }
        else {
            ChiTieuCaNhan chiTieuCaNhan = new ChiTieuCaNhan(String.valueOf(edtNoiDung.getText()),
                    Integer.valueOf(edtSoTien.getText().toString()));
            chiTieuCaNhanList.add(chiTieuCaNhan);
        }
        return chiTieuCaNhanList;
    }

    private void tinhTongChiTieu(ArrayList<ChiTieuCaNhan> chiTieuCaNhanList){
        tongTien = Long.valueOf(0);
        chiTieuCaNhanList.forEach(chiTieuCaNhan -> {
            tongTien = tongTien + chiTieuCaNhan.getSoTienChiTieu();
        });
        txtTongTien.setText(tongTien.toString());
    }

    private void resetTextBox(){
        edtNoiDung.setText("");
        edtSoTien.setText("");
    }

}