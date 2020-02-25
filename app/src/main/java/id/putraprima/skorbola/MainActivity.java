package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.UserHandle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public static final String HOMETEAM_KEY = "hometeam";
    public static final String AWAYTEAM_KEY = "awayteam";
    private EditText hometeamInput;
    private EditText awayteamInput;
    private ImageView homeLogo;
    private ImageView awayLogo;

    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hometeamInput = findViewById(R.id.home_team);
        awayteamInput = findViewById(R.id.away_team);
    }

    public void handleNext(View view) {
        String homeTeam = hometeamInput.getText().toString();
        String awayTeam = awayteamInput.getText().toString();


        Intent intent =  new Intent(this, MatchActivity.class);
        intent.putExtra(HOMETEAM_KEY, homeTeam);
        intent.putExtra(AWAYTEAM_KEY, awayTeam);
        startActivity(intent);
    }
}
//TODO
//Fitur Main Activity
//1. Validasi Input Home Team
//2. Validasi Input Away Team
//3. Ganti Logo Home Team
//4. Ganti Logo Away Team
//5. Next Button Pindah Ke MatchActivity