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

public class TempFragment extends Fragment {

    private MaterialButtonToggleGroup toggleGroup;
    private TextInputLayout inputLayout;
    private TextInputEditText etInput;
    private MaterialButton btnConvert;
    private TextView tvResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflation de la vue Premium
        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        // Initialisation des composants
        toggleGroup = view.findViewById(R.id.toggleGroupTemp);
        inputLayout = view.findViewById(R.id.tilTempInput);
        etInput = view.findViewById(R.id.etTempInput);
        btnConvert = view.findViewById(R.id.btnConvertTemp);
        tvResult = view.findViewById(R.id.tvTempResult);

        // Configuration du listener
        btnConvert.setOnClickListener(v -> performConversion());

        return view;
    }

    private void performConversion() {
        String inputStr = etInput.getText().toString().trim();

        // Gestion d'erreur Premium : Affichage directement sur le champ
        if (inputStr.isEmpty()) {
            inputLayout.setError("La valeur est requise");
            return;
        } else {
            inputLayout.setError(null); // Effacer l'erreur
        }

        try {
            double val = Double.parseDouble(inputStr);
            double result;
            String unit;

            // Vérification du sens via le ToggleGroup
            if (toggleGroup.getCheckedButtonId() == R.id.btnCtoF) {
                result = (val * 1.8) + 32;
                unit = " °F";
            } else {
                result = (val - 32) / 1.8;
                unit = " °C";
            }

            // Affichage formaté Premium
            tvResult.setText(String.format(Locale.getDefault(), "%.1f%s", result, unit));

        } catch (NumberFormatException e) {
            inputLayout.setError("Format de nombre invalide");
        }
    }
}