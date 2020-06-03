package com.example.tallermanillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import static java.lang.Double.doubleToRawLongBits;
import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    private EditText cantidad;
    private TextView valorPagar;
    private Spinner combo_Materiales, combo_Dije, combo_Tipo, combo_Moneda;
    private String[] material, dije, tipo, moneda;
    private ArrayAdapter<String> adaptermaterial, adapterdije, adaptertipo, adaptermoneda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cantidad = findViewById(R.id.txtCantidad);
        valorPagar = findViewById(R.id.lblValorPagar);
        combo_Materiales= findViewById(R.id.cmbMaterial);
        combo_Dije=findViewById(R.id.cmbDije);
        combo_Tipo=findViewById(R.id.cmbTipo);
        combo_Moneda=findViewById(R.id.cmbMoneda);

        material=getResources().getStringArray(R.array.materiales);
        dije=getResources().getStringArray(R.array.dije);
        tipo=getResources().getStringArray(R.array.tipo);
        moneda=getResources().getStringArray(R.array.moneda);

        adaptermaterial=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, material);
        combo_Materiales.setAdapter(adaptermaterial);
        adapterdije = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,dije);
        combo_Dije.setAdapter(adapterdije);
        adaptertipo= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tipo);
        combo_Tipo.setAdapter(adaptertipo);
        adaptermoneda= new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, moneda);
        combo_Moneda.setAdapter(adaptermoneda);

    }
    public void calcularPago(View v){
        int mat, dij, tip, mon, valuni;
        double can, pag=0;
        can= parseDouble(cantidad.getText().toString());
        mat=combo_Materiales.getSelectedItemPosition();
        dij=combo_Dije.getSelectedItemPosition();
        tip=combo_Tipo.getSelectedItemPosition();
        mon=combo_Moneda.getSelectedItemPosition();

        switch (mat){
            case 0:
                switch (dij){
                    case 0:
                        switch (tip){
                            case 0:
                                valuni=100;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni *can)*3200;
                                        break;
                                }break;
                            case 1:
                                valuni=80;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                            case 2:
                                valuni=70;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                        }break;
                    case 1:
                        switch (tip){
                            case 0:
                                valuni=120;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                            case 1:
                                valuni=100;
                                switch (mon) {
                                    case 0:
                                        pag = valuni * can;
                                        break;
                                    case 1:
                                        pag = (valuni * can) * 3200;
                                        break;
                                }break;
                            case 2:
                                valuni= 90;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                        }break;
                }break;
            case 1:
                switch (dij){
                    case 0:
                        switch (tip){
                            case 0:
                                valuni=90;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                            case 1:
                                valuni=70;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                            case 2:
                                valuni=50;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                        }break;
                    case 1:
                        switch (tip){
                            case 0:
                                valuni=110;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                            case 1:
                                valuni=90;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                            case 2:
                                valuni=80;
                                switch (mon){
                                    case 0:
                                        pag=valuni*can;
                                        break;
                                    case 1:
                                        pag=(valuni*can)*3200;
                                        break;
                                }break;
                        }break;
                }break;
        }
        valorPagar.setText("" + pag);
    }

public boolean validar(){
        String error_cantidadcero, errorcantidadv;

        error_cantidadcero=getResources().getString(R.string.error_cantidadcero);
        errorcantidadv=getResources().getString(R.string.error_cantidadv);

        if(cantidad.getText().toString().isEmpty()){
            cantidad.setError(errorcantidadv);
            cantidad.requestFocus();
            return false;
        }
        if (Double.parseDouble(cantidad.getText().toString())==0){
            cantidad.setError(error_cantidadcero);
            cantidad.requestFocus();
            return false;
        }
        return true;
}

}
