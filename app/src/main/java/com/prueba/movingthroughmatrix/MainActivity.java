package com.prueba.movingthroughmatrix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements InterfaceDirection.View {
    EditText et_rows_input;
    EditText et_columns_input;
    Button btn_get_direction;
    TextView txt_direction;
    ProgressBar progressBar;
    InterfaceDirection.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_rows_input = findViewById(R.id.rows_input);
        et_columns_input = findViewById(R.id.columns_input);
        btn_get_direction = findViewById(R.id.btn_get_direction);
        txt_direction = findViewById(R.id.direction);
        progressBar = findViewById(R.id.progress_bar);

        btn_get_direction.setOnClickListener(v -> calculate());

        presenter = new MainPresenter(this);
    }

    private void calculate() {
        presenter.getDirection(et_rows_input.getText().toString(), et_columns_input.getText().toString());
    }

    @Override
    public void showProgressBar() {
        runOnUiThread(() -> progressBar.setVisibility(View.VISIBLE));
    }

    @Override
    public void showResult(String result) {
        progressBar.setVisibility(View.GONE);
        txt_direction.setText(result);
    }

    @Override
    public void showError(String error) {
        txt_direction.setText(error);
    }
}
