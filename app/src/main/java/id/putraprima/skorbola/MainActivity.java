package id.putraprima.skorbola;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static final String HOMETEAM_KEY = "hometeam";
    public static final String AWAYTEAM_KEY = "awayteam";
    private EditText hometeamInput;
    private EditText awayteamInput;
    private ImageView homeLogo;
    private ImageView awayLogo;

    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int GALLERY_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hometeamInput = findViewById(R.id.home_team);
        awayteamInput = findViewById(R.id.away_team);
        homeLogo = findViewById(R.id.home_logo);
        awayLogo = findViewById(R.id.away_logo);
    }

    public void handlelogoHome(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1);
    }

    public void handlelogoAway(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        if (requestCode == 1) {
            if (data != null) {
                try {
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    homeLogo.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        } else if (requestCode == 2) {
            if (data != null) {
                try {
                    Uri imageUri= data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    awayLogo.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }
    public void handleNext(View view) {
        String homeTeam = hometeamInput.getText().toString().trim();
        String awayTeam = awayteamInput.getText().toString().trim();
        Intent intent =  new Intent(this, MatchActivity.class);

        if(homeLogo != null){
            handlelogoHome(view);
            Toast.makeText(this, "Tambahkan Logo Tim dulu"+ homeLogo, Toast.LENGTH_SHORT).show();
        }
        if(awayLogo != null){
            handlelogoAway(view);
            Toast.makeText(this, "Tambahkan Logo Tim dulu"+ awayLogo, Toast.LENGTH_SHORT).show();
        }
        if(!(homeTeam).equals("") && !(awayTeam).equals("")){
            intent.putExtra(HOMETEAM_KEY, homeTeam);
            intent.putExtra(AWAYTEAM_KEY, awayTeam);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Tolong Isi Nama Tim yang Kosong !", Toast.LENGTH_SHORT).show();
        }
    }
}
//TODO
//Fitur Main Activity
//1. Validasi Input Home Team
//2. Validasi Input Away Team
//3. Ganti Logo Home Team
//4. Ganti Logo Away Team
//5. Next Button Pindah Ke MatchActivity