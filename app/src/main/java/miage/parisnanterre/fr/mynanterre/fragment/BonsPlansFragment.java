package miage.parisnanterre.fr.mynanterre.fragment;

/*
 * Created by Sankar Vijay on 18/01/2019.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import miage.parisnanterre.fr.mynanterre.implem.BonPlan;
import miage.parisnanterre.fr.mynanterre.R;
import miage.parisnanterre.fr.mynanterre.adapter.BonPlanAdapter;


public class BonsPlansFragment extends Fragment {
    private List<BonPlan> listeb = new ArrayList<>();
    private BonPlanAdapter bAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.liste_bonplan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);

        bAdapter = new BonPlanAdapter(listeb);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(bAdapter);

         /*try {
            Class.forName("com.mysql.jdbc.Driver");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Problème au niveau du driver", Toast.LENGTH_SHORT).show();
        }
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
*/
        prepareBonplanData();


    }

    private void prepareBonplanData() {

      /*  try{

            conn = DriverManager.getConnection(url, user, psw);
            String sqliD = "SELECT * FROM jobs ";
            Statement st = conn.createStatement();
            ResultSet rst = st.executeQuery(sqliD);

            String titre=  rst.getString("titre");
            String entreprise=  rst.getString("entreprise");
            String localisation=  rst.getString("localisation");
            Date datePublicaton=  rst.getDate("date_publication");
            String descriptif=  rst.getString("descriptif");
            String siteWeb=  rst.getString("site_web");
            System.out.println("titre"+titre);
            while(rst.next()){
                Offre offre = new Offre(R.drawable.sopra,titre,"Stage",localisation,descriptif
                        ,"10/01/2019",entreprise);
                listeOffre.add(offre);
            }
            oAdapter.notifyDataSetChanged();

        }catch (SQLException e){
            e.printStackTrace();
        }*/
        BonPlan bonplan = new BonPlan(R.drawable.boursorama, "Vente privée Boursorama : jusqu'à 130€ offerts pour une ouverture de compte", "jusqu'au" + "20/01/2019");
        listeb.add(bonplan);
        bonplan = new BonPlan(R.drawable.apple, "Sur l’Apple Store Éducation et économisez jusqu’à 330 € sur un nouveau Mac, et jusqu’à 105 € sur un nouvel iPad", "illimité");
        listeb.add(bonplan);

        bonplan = new BonPlan(R.drawable.uber, "Votre première course gratuite à hauteur de 15€ sur l'application UBER", "jusqu'au" + "17/09/2019");
        listeb.add(bonplan);

        bonplan = new BonPlan(R.drawable.newlook, "-10% sur tous les articles sur présentation de la carte étudiante - NEWLOOK", "jusqu'au" + "12/11/2019");
        listeb.add(bonplan);

        bonplan = new BonPlan(R.drawable.otacos, "Le Menu taille M + boisson à 5€ pour les étudiants chez Otacos", "jusqu'au" + "15/03/2019");
        listeb.add(bonplan);

        bonplan = new BonPlan(R.drawable.spotify, "Coupez les distractions, pas la musique. Spotify Premium à 4,99€/mois pour les étudiants", "illimité");
        listeb.add(bonplan);


        bAdapter.notifyDataSetChanged();
    }
}
