package miage.parisnanterre.fr.mynanterre.implem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import miage.parisnanterre.fr.mynanterre.R;

/**
 * Created by Sankar Vijay on 01/02/2019.
 */
public class Plannification extends Activity {
    private static final String url = "jdbc:mysql://sql171.main-hosting.eu/u749839367_m1";
    private static final String user = "u749839367_vijay";
    private static final String psw = "9IDCqTm8Lig2";
    private static Connection conn;
    private EditText numero, heureD, heureF, sport, lieu;
    private Button planifier;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formrdv);

        numero = (EditText) findViewById(R.id.numero);

        heureD = (EditText) findViewById(R.id.heureD);
        heureF = (EditText) findViewById(R.id.heureF);
        sport = (EditText) findViewById(R.id.sport);
        lieu = (EditText) findViewById(R.id.lieu);
        planifier = (Button) findViewById(R.id.planifier);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        planifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    conn = DriverManager.getConnection(url, user, psw);
                    String sqliD = "insert into plannification_sport (nom,prenom,heure_d,heure_f,sport,lieu) values (?,?,?,?,?,?) ;";
                    PreparedStatement preparedStatement = conn.prepareStatement(sqliD);
                    System.out.println("Nom " + numero.getText().toString());
                    System.out.println("Heure D " + heureD.getText().toString());

                    preparedStatement.setString(1, numero.getText().toString());

                    preparedStatement.setString(2, heureD.getText().toString());
                    preparedStatement.setString(3, heureF.getText().toString());
                    preparedStatement.setString(4, sport.getText().toString());
                    preparedStatement.setString(5, lieu.getText().toString());
                    preparedStatement.executeUpdate();
                    Toast.makeText(getApplicationContext(), "Votre séance a bien été planifié !", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Plannification.this, ListeSport.class));

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}