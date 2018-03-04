package morasquad.me.retrofitapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Profile extends AppCompatActivity {

    TextView name,email;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        if (!SharedPref.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

        SharedPref sharedPref = new SharedPref(getApplicationContext());
        name = (TextView) findViewById(R.id.welcome);
        email = (TextView) findViewById(R.id.email);
        logout = (Button) findViewById(R.id.logout);


        name.setText("Welcome User " + SharedPref.getInstance(this).getUser().getName());
        email.setText("Your Email is " + SharedPref.getInstance(this).getUser().getEmail());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
                Intent i = new Intent(Profile.this,SigninActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);

                Toast.makeText(getApplicationContext(),"Successfully Logged Out!",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void logout(){
        SharedPref.getInstance(this).logout();

        finish();
    }
}
