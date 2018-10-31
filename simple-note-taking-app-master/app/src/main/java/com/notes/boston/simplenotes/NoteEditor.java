package com.notes.boston.simplenotes;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NoteEditor extends AppCompatActivity {

    private DbHelper dbHelper = null;
    private SQLiteDatabase db = null;

    public EditText conTitle;
    public EditText conBody;
    private Intent intent;
    private String title;
    private String body;
    private long col_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);

        intent = getIntent();

        dbHelper = new DbHelper(this);
        db = dbHelper.getWritableDatabase();

        conTitle = findViewById(R.id.note_title);
        conBody = findViewById(R.id.note_body);

        title = intent.getStringExtra("Title");
        body = intent.getStringExtra("Body");
        col_ID = intent.getLongExtra("noteid", 1);

        conTitle.setText(title);
        conBody.setText(body);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.itemSave){


            if(col_ID == 1) {
                long add = dbHelper.insertNote(db, conTitle.getText().toString(), conBody.getText().toString());

                Toast.makeText(this, "Note has been saved!", Toast.LENGTH_SHORT).show();

                this.finish();
            }
            else
            {
                boolean update = dbHelper.updateNote(db, col_ID ,conTitle.getText().toString(), conBody.getText().toString());
                if (update) {
                    Toast.makeText(this, "Note has been updated!", Toast.LENGTH_SHORT).show();
                    this.finish();
                }else{}
            }
        }

        return true;
    }
}
