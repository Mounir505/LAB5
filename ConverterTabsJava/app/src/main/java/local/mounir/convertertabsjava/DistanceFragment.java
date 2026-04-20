package local.mounir.convertertabsjava;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class DistanceFragment extends Fragment {

    private MaterialButtonToggleGroup toggleGroup;
    private TextInputLayout inputLayout;
    private TextInputEditText etInput;
    private MaterialButton btnConvert;
    private TextView tvResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflation de la vue
        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        // Initialisation des composants Material
        toggleGroup = view.findViewById(R.id.toggleGroupDist);
        inputLayout = view.findViewById(R.id.tilDistInput);
        etInput = view.findViewById(R.id.etDistInput);
        btnConvert = view.findViewById(R.id.btnConvertDist);
        tvResult = view.findViewById(R.id.tvDistResult);

        // Gestion du clic sur le bouton Calculer
        btnConvert.setOnClickListener(v -> performConversion());

        return view;
    }

    /**
     * Logique de conversion Premium
     */
    private void performConversion() {
        String inputStr = etInput.getText().toString().trim();

        // Validation du champ (évite le Toast, utilise l'erreur visuelle du champ)
        if (inputStr.isEmpty()) {
            inputLayout.setError(getString(R.string.hint_distance)); // Message d'erreur pro
            return;
        } else {
            inputLayout.setError(null); // Efface l'erreur si tout est bon
        }

        try {
            double val = Double.parseDouble(inputStr);
            double result;
            String unitLabel;

            // Vérification du sens de conversion via les IDs du ToggleGroup
            if (toggleGroup.getCheckedButtonId() == R.id.btnKmToMiles) {
                result = val * 0.621371;
                unitLabel = " Miles";
            } else {
                result = val / 0.621371;
                unitLabel = " Km";
            }

            // Affichage du résultat formaté (2 décimales)
            tvResult.setText(String.format(Locale.getDefault(), "%.2f%s", result, unitLabel));

        } catch (NumberFormatException e) {
            inputLayout.setError("Format de nombre invalide");
        }
    }
}