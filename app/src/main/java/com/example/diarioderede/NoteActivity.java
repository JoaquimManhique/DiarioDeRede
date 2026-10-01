package com.example.diarioderede;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class NoteActivity extends AppCompatActivity {

    private EditText etNoteInput;
    private Button btnSaveNote;
    private ListView lvNotes;

    private ArrayList<String> notesList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        etNoteInput = findViewById(R.id.etNoteInput);
        btnSaveNote = findViewById(R.id.btnSaveNote);
        lvNotes = findViewById(R.id.lvNotes);

        notesList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, notesList);
        lvNotes.setAdapter(adapter);

        btnSaveNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String noteText = etNoteInput.getText().toString().trim();

                if (!noteText.isEmpty()) {
                    // Captura automática da data e hora atual do sistema
                    String currentDateAndTime = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(new Date());

                    // Junta a data/hora com o texto da nota
                    String finalNoteEntry = currentDateAndTime + "\n" + noteText;

                    // Adiciona ao topo da lista
                    notesList.add(0, finalNoteEntry);
                    adapter.notifyDataSetChanged();

                    // Limpa a caixa de texto
                    etNoteInput.setText("");
                    Toast.makeText(NoteActivity.this, "Nota guardada com sucesso!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(NoteActivity.this, "Escreve algo antes de guardar.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}