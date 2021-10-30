package com.example.bai7_cau4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private SQLiteDatabase sqLiteDatabase;
    private DBHelper dbHelper;
    private final String[] allColumns = {DBHelper.key_id, DBHelper.key_noidungchitieu, DBHelper.key_sotienchitieu};
    public DataSource(Context context){
        dbHelper = new DBHelper(context);
    }
    public void open() throws SQLException {
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public void close(){
        dbHelper.close();
    }

    public void createChiTieu(ChiTieuCaNhan chiTieuCaNhan){
        ContentValues values = new ContentValues();
        values.put(DBHelper.key_noidungchitieu, chiTieuCaNhan.getNoiDungChiTieu());
        values.put(DBHelper.key_sotienchitieu, chiTieuCaNhan.getSoTienChiTieu());
        sqLiteDatabase.insert(DBHelper.table_name, null, values);
    }

    public List<ChiTieuCaNhan> getAllChiTieu(){
        List<ChiTieuCaNhan> listResult = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(DBHelper.table_name, allColumns,
                null, null, null, null,null );
        if (cursor == null || cursor.getCount() <= 0)
            return null;
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            ChiTieuCaNhan chiTieuCaNhan = cursorToChiTieuCaNhan(cursor);
            listResult.add(chiTieuCaNhan);
            cursor.moveToNext();
        }
        cursor.close();
        return listResult;
    }
    private ChiTieuCaNhan cursorToChiTieuCaNhan(Cursor cursor){
        ChiTieuCaNhan chiTieuCaNhan = new ChiTieuCaNhan();
        chiTieuCaNhan.setNoiDungChiTieu(cursor.getString(1));
        chiTieuCaNhan.setSoTienChiTieu(cursor.getInt(2));
        return chiTieuCaNhan;
    }
    public void deleteChiTieu(String noidung) {
        sqLiteDatabase.delete(DBHelper.table_name, DBHelper.key_noidungchitieu + " = ?",
                new String[]{noidung});
    }
    public void updateChiTieu(ChiTieuCaNhan chiTieuCaNhan) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.key_sotienchitieu, chiTieuCaNhan.getSoTienChiTieu());
        sqLiteDatabase.update(DBHelper.table_name, values, DBHelper.key_noidungchitieu + " = ?",
                new String[]{String.valueOf(chiTieuCaNhan.getNoiDungChiTieu())});
    }
}
