package miage.parisnanterre.fr.mynanterre.implem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.fragment.AccueilFragment;
import miage.parisnanterre.fr.mynanterre.fragment.CrousFragment;
import miage.parisnanterre.fr.mynanterre.fragment.SportFragment;
import miage.parisnanterre.fr.mynanterre.fragment.TrainFragment;

public class Cgu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cgu_app);

    }
}

