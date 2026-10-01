package com.example.diarioderede;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvNetworkStatus;
    private Button btnOpenNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNetworkStatus = findViewById(R.id.tvNetworkStatus);
        btnOpenNotes = findViewById(R.id.btnOpenNotes);

        // Verifica o estado atual da rede ao abrir a app
        checkNetworkStatus();

        // Intent para navegar para a segunda Activity (Diário de Notas)
        btnOpenNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void checkNetworkStatus() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            Network network = connectivityManager.getActiveNetwork();
            if (network == null) {
                tvNetworkStatus.setText("Estado: Sem Ligação");
                return;
            }

            NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);
            if (capabilities == null) {
                tvNetworkStatus.setText("Estado: Sem Ligação");
                return;
            }

            if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                tvNetworkStatus.setText("Estado: Ligado via Wi-Fi");
            } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                tvNetworkStatus.setText("Estado: Ligado via Dados Móveis");
            } else {
                tvNetworkStatus.setText("Estado: Outra Ligação Ativa");
            }
        } else {
            tvNetworkStatus.setText("Estado: Indisponível");
        }
    }
}