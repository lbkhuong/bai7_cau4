package com.example.bai7_cau4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String db_name = "qlchitieu.db";
    public static final String table_name = "Chi_Tieu_Ca_Nhan";
    public static final String key_id = "ID";
    public static final String key_noidungchitieu = "Noi_Dung";
    public static final String key_sotienchitieu = "So_Tien";
    private static final int version = 1;
    private static final String create_table = String.format
            ("CREATE TABLE %s(%s INTEGER PRIMARY KEY, %s TEXT, %s INTEGER)",
                    table_name, key_id, key_noidungchitieu, key_sotienchitieu);
    private static final String drop_table = "DROP TABLE IF EXISTS " + table_name;

    public DBHelper(Context context) {
        super(context, db_name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(create_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(drop_table);
        onCreate(sqLiteDatabase);
    }
}
