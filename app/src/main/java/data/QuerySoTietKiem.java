package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sotietkiem.SignInActivity;

import java.util.ArrayList;

import InOut.MoneyInActivity;

public class QuerySoTietKiem {
    public static void insert(Context context, SoTietKiem soMoi)
    {
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(helper.COLUMN_ID_USER, SignInActivity.loginUser.getId());
        values.put(helper.COLUMN_NAME_SO,soMoi.getTenSo());
        values.put(helper.COLUMN_MONEY_SO,soMoi.getTienTietKiem());
        db.insert(helper.TABLE_NAME1,null,values);
        db.close();
    }

    public static ArrayList<SoTietKiem> ListSoTietKiem(Context context, User user)
    {
        ArrayList<SoTietKiem> lstStk = new ArrayList<>();
        DatabaseHandler helper = new DatabaseHandler(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        String sql="SELECT * from "+helper.TABLE_NAME1+" WHERE "
                +helper.COLUMN_ID_USER
                +" = "
                +user.id
                +";";
        Cursor cs=db.rawQuery(sql,null);
        cs.moveToFirst();
        while (!cs.isAfterLast())
        {
            int id = cs.getInt(0);
            int idUser = cs.getInt(1);
            String tenSo = cs.getString(2);
            int tienStk = cs.getInt(3);

            lstStk.add(new SoTietKiem(id,idUser,tenSo,tienStk));
            cs.moveToNext();
        }
        cs.close();
        return lstStk;
    }
}
