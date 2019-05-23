package pe.ebenites.sugarormapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.MediaController;
import android.widget.TextView;

import pe.ebenites.sugarormapp.R;
import pe.ebenites.sugarormapp.models.User;
import pe.ebenites.sugarormapp.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {

    private TextView fullnameText;
    GridLayout mainGrid;
    MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        fullnameText = findViewById(R.id.fullname_text);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        Long id = sp.getLong("id", 0);

        User user = UserRepository.load(id);

        if(user == null) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        fullnameText.setText(user.getFullname());

    }
}
