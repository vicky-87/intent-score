package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static id.putraprima.skorbola.MainActivity.AWAYTEAM_KEY;
import static id.putraprima.skorbola.MainActivity.HOMETEAM_KEY;

public class MatchActivity extends AppCompatActivity {
    private TextView hometeamText;
    private TextView awayteamText;
    private TextView homeCount;
    private TextView awayCount;
    private TextView resultCount;

    int counterHome = 0;
    int counterAway = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);

        //TODO
        hometeamText = findViewById(R.id.home_team);
        awayteamText = findViewById(R.id.away_team);
        //COUNT
        homeCount = (TextView) findViewById(R.id.score_home);
        awayCount = (TextView) findViewById(R.id.score_away);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            // TODO: display value here
            hometeamText.setText(extras.getString(HOMETEAM_KEY));
            awayteamText.setText(extras.getString(AWAYTEAM_KEY));
        }
    }

    public void handleCek(View view) {
        Intent intent =  new Intent(this, ResultActivity.class);
        startActivity(intent);
    }
}
//1.Menampilkan detail match sesuai data dari main activity
//2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
//3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
