package com.example.bai7_cau4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ChiTieuAdapter extends BaseAdapter {
    private final List<ChiTieuCaNhan> chiTieuCaNhanList;
    private final Activity activity;

    public ChiTieuAdapter(Activity activity, List<ChiTieuCaNhan> chiTieuCaNhanList){
        this.activity = activity;
        this.chiTieuCaNhanList = chiTieuCaNhanList;
    }
    @Override
    public int getCount() {
        return chiTieuCaNhanList.size();
    }

    @Override
    public Object getItem(int i) {
        return chiTieuCaNhanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.item_listview, null);
        TextView txtNoiDungCT = view.findViewById(R.id.txtNoiDungCT);
        TextView txtSoTienCT = view.findViewById(R.id.txtSoTienCT);
        String noidung = chiTieuCaNhanList.get(i).getNoiDungChiTieu();
        String sotien = String.valueOf(chiTieuCaNhanList.get(i).getSoTienChiTieu());
        txtNoiDungCT.setText(noidung);
        txtSoTienCT.setText(sotien);
        return view;
    }
}
