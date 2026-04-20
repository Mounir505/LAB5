package local.mounir.convertertabsjava; // Vérifiez que le package correspond au vôtre

import android.os.Bundle;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupNavigation();
        setupBackPressedHandling();
    }

    /**
     * Initialisation de la Toolbar, du ViewPager2 et des Onglets
     */
    private void setupNavigation() {
        // Toolbar Premium
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // Configuration de l'adaptateur
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Liaison Premium avec icônes et texte
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("Température");
                // SUPPRIMEZ la ligne tab.setIcon(...)
            } else {
                tab.setText("Distance");
                // SUPPRIMEZ la ligne tab.setIcon(...)
            }
        }).attach();
    }

    /**
     * Gestion moderne de la touche retour (onBackPressed est déprécié)
     */
    private void setupBackPressedHandling() {
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showExitDialog();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);
    }

    /**
     * Dialogue de sortie stylisé Material 3
     */
    private void showExitDialog() {
        new MaterialAlertDialogBuilder(this)
                .setTitle("Quitter l'application")
                .setMessage("Toutes les données non sauvegardées seront perdues. Voulez-vous vraiment quitter ?")
                .setPositiveButton("Quitter", (dialog, which) -> finish())
                .setNegativeButton("Annuler", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}