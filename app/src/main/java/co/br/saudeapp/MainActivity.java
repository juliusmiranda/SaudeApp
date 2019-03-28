package co.br.saudeapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {

    EditText peso, altura, cintura, busto, quadril, biceps, quadriceps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = findViewById(R.id.txtPeso);
        altura = findViewById(R.id.txtAltura);
        cintura = findViewById(R.id.txtCintura);
        busto = findViewById(R.id.txtBusto);
        quadril = findViewById(R.id.txtQuadril);
        biceps = findViewById(R.id.txtBiceps);
        quadriceps = findViewById(R.id.txtQuadriceps);

        onLoad();

    }

    public void onLoad() {
        SharedPreferences data = getSharedPreferences("MinhaSaude", MODE_PRIVATE);

        String sPeso = data.getString("Peso", "");
        String sAltura = data.getString("Altura", "");
        String sCintura = data.getString("Cintura","");
        String sBusto = data.getString("Busto", "");
        String sQuadril = data.getString("Quadril", "");
        String sBiceps = data.getString("Biceps", "");
        String sQuadriceps = data.getString("Quadriceps", "");

        if(sPeso != "") {
            peso.setText(sPeso);
        }
        if(sAltura != "") {
            altura.setText(sAltura);
        }
        if(sCintura != "") {
            cintura.setText(sCintura);
        }
        if(sBusto != "") {
            busto.setText(sBusto);
        }
        if(sQuadril != "") {
            quadril.setText(sQuadril);
        }
        if(sBiceps != "") {
            biceps.setText(sBiceps);
        }
        if(sQuadriceps != "") {
            quadriceps.setText(sQuadriceps);
        }
    }

    public void salvar(View v){
        SharedPreferences data = getSharedPreferences("MinhaSaude", MODE_PRIVATE);
        SharedPreferences.Editor editor = data.edit();

        editor.putString("Peso", peso.getText().toString());
        editor.putString("Altura", altura.getText().toString());
        editor.putString("Cintura", cintura.getText().toString());
        editor.putString("Busto", busto.getText().toString());
        editor.putString("Quadril", quadril.getText().toString());
        editor.putString("Biceps", biceps.getText().toString());
        editor.putString("Quadriceps", quadriceps.getText().toString());

        editor.apply();

        Toast.makeText(getApplicationContext(),"Informações salvas com sucesso", Toast.LENGTH_LONG).show();

    }
}
