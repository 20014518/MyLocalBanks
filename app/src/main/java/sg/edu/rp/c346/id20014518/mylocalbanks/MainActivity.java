package sg.edu.rp.c346.id20014518.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvTranslatedTextDBS, tvTranslatedTextOCBC, tvTranslatedTextUOB;
    String wordClicked;
    boolean dbsblack = true;
    boolean ocbcblack = true;
    boolean uobblack = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedTextDBS = findViewById(R.id.textViewDBS);
        tvTranslatedTextOCBC = findViewById(R.id.textViewOCBC);
        tvTranslatedTextUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvTranslatedTextDBS);
        registerForContextMenu(tvTranslatedTextOCBC);
        registerForContextMenu(tvTranslatedTextUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == tvTranslatedTextDBS) {
            wordClicked = "DBS";
        } else if (v == tvTranslatedTextOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvTranslatedTextUOB) {
            wordClicked = "UOB";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (id == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
            } else if (id == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(intentCall);
            } else if (id == 2 && dbsblack == true) {
                dbsblack = false;
                tvTranslatedTextDBS.setTextColor(Color.parseColor("#FF0000"));
            } else if (id == 2 && dbsblack == false) {
                dbsblack = true;
                tvTranslatedTextDBS.setTextColor(Color.parseColor("#000000"));
            }

        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (id == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
            } else if (id == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18003633333"));
                startActivity(intentCall);
            } else if (id == 2 && ocbcblack == true) {
                ocbcblack = false;
                tvTranslatedTextOCBC.setTextColor(Color.parseColor("#FF0000"));
            } else if (id == 2 && ocbcblack == false) {
                ocbcblack = true;
                tvTranslatedTextOCBC.setTextColor(Color.parseColor("#000000"));
            }

        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (id == 0) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
            } else if (id == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                startActivity(intentCall);
            } else if (id == 2 && uobblack == true) {
                uobblack = false;
                tvTranslatedTextUOB.setTextColor(Color.parseColor("#FF0000"));
            } else if (id == 2 && uobblack == false) {
                uobblack = true;
                tvTranslatedTextUOB.setTextColor(Color.parseColor("#000000"));
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection){
            tvTranslatedTextDBS.setText("DBS");
            tvTranslatedTextOCBC.setText("OCBC");
            tvTranslatedTextUOB.setText("UOB");
        }
        else if (id == R.id.ChineseSelection){
            tvTranslatedTextDBS.setText("星展银行");
            tvTranslatedTextOCBC.setText("华侨银行");
            tvTranslatedTextUOB.setText("大华银行");
        }
        return super.onOptionsItemSelected(item);
    }
}