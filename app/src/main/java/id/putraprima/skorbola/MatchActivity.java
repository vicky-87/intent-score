package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static id.putraprima.skorbola.MainActivity.AWAYTEAM_KEY;
import static id.putraprima.skorbola.MainActivity.HOMETEAM_KEY;

public class MatchActivity extends AppCompatActivity {
    private TextView hometeamText;
    private TextView awayteamText;
    private TextView homeCount;
    private TextView awayCount;
    private ImageView homeLogo;
    private ImageView awayLogo;
    private static final String RESULT_KEY = "result";
    public static final String IMAGE_KEY_HOME = "imagehome";
    public static final String IMAGE_KEY_AWAY = "imageaway";

    int counterHome = 0;
    int counterAway = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        //TODO
        hometeamText = findViewById(R.id.txt_home);
        awayteamText = findViewById(R.id.txt_away);
        //COUNT
        homeCount = findViewById(R.id.score_home);
        awayCount = findViewById(R.id.score_away);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // TODO: display value here
            hometeamText.setText(extras.getString(HOMETEAM_KEY));
            awayteamText.setText(extras.getString(AWAYTEAM_KEY));
            Bitmap home = extras.getParcelable(IMAGE_KEY_HOME);
            Bitmap away = extras.getParcelable(IMAGE_KEY_AWAY);
            homeLogo.setImageBitmap(home);
            awayLogo.setImageBitmap(away);
        }
    }

    public void handleAddHome(View view) {
        counterHome++;
        homeCount.setText(Integer.toString(counterHome));
    }

    public void handleAddAway(View view) {
        counterAway++;
        awayCount.setText(Integer.toString(counterAway));
    }

    public void handleCek(View view) {
        String result;
        Intent intent = new Intent(this, ResultActivity.class);

        if (counterHome > counterAway) {
            result = hometeamText.getText().toString() + " Is the Winner";
        } else if (counterHome < counterAway) {
            result = awayteamText.getText().toString() + " Is the Winner";
        } else {
            result = " Is Draw";
        }
        intent.putExtra(RESULT_KEY, result);
        startActivity(intent);
    }
}
//1.Menampilkan detail match sesuai data dari main activity
//2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
//3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
