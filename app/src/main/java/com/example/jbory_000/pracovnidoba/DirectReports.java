package com.example.jbory_000.pracovnidoba;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;




public class DirectReports extends ListActivity {

    protected Cursor cursor=null;
    protected ListAdapter adapter;

    @SuppressLint({"SetTextI18n", "Recycle"})
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.direct_reports);

        SQLiteDatabase db = (new DatabaseHelper(this)).getWritableDatabase();

        int employeeId = getIntent().getIntExtra("EMPLOYEE_ID", 0);

        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT _id, firstName, lastName, title FROM employee WHERE _id = 1",
                new String[]{""+employeeId});

        if (cursor.getCount() != 1)
        {
            return;
        }

        cursor.moveToFirst();

        TextView employeeNameText = findViewById(R.id.employeeName);
        employeeNameText.setText(cursor.getString(cursor.getColumnIndex("firstName")) + " " + cursor.getString(cursor.getColumnIndex("lastName")));

        TextView titleText = findViewById(R.id.title);
        titleText.setText(cursor.getString(cursor.getColumnIndex("title")));

        cursor = db.rawQuery("SELECT _id, firstName, lastName, title, officePhone, cellPhone, email FROM employee WHERE managerId = 1",
                new String[]{""+employeeId});
        adapter = new SimpleCursorAdapter(
                this,
                R.layout.employee_list_item,
                cursor,
                new String[] {"firstName", "lastName", "title"},
                new int[] {R.id.firstName, R.id.lastName, R.id.title});
        setListAdapter(adapter);
    }

    public void onListItemClick(ListView parent, View view, int position, long id) {
        Intent intent = new Intent(this, EmployeeDetails.class);
        Cursor cursor = (Cursor) adapter.getItem(position);
        intent.putExtra("EMPLOYEE_ID", cursor.getInt(cursor.getColumnIndex("_id")));
        startActivity(intent);
    }

}