package local.mounir.convertertabsjava;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Adaptateur Premium pour la gestion des fragments d'onglets.
 * Utilise FragmentStateAdapter pour une gestion optimale de la mémoire.
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    // Définition du nombre d'onglets en constante pour la maintenance
    private static final int CARD_COUNT = 2;
    public static final int INDEX_TEMP = 0;
    public static final int INDEX_DIST = 1;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Utilisation d'un switch (plus Pro et évolutif qu'un if/else)
        switch (position) {
            case INDEX_TEMP:
                return new TempFragment();
            case INDEX_DIST:
                return new DistanceFragment();
            default:
                throw new IllegalArgumentException("Position d'onglet invalide : " + position);
        }
    }

    @Override
    public int getItemCount() {
        return CARD_COUNT;
    }
}