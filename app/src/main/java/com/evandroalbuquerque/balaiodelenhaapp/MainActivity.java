package com.evandroalbuquerque.balaiodelenhaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText consumo_total;
    private EditText conta_total;
    private EditText taxa_servico;
    private EditText couvert_artistico;
    private EditText dividir_conta_por;
    private EditText valor_conta_pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consumo_total = findViewById(R.id.edt_consumo);
        conta_total = findViewById(R.id.edt_conta_total);
        taxa_servico = findViewById(R.id.edt_servico);
        couvert_artistico = findViewById(R.id.edt_couvert_artistico);
        dividir_conta_por = findViewById(R.id.edt_dividir);
        valor_conta_pessoa = findViewById(R.id.edt_valor_pessoa);

    }


    public void btnCalcularContaFinal(View v) {
        double consumoTotal = Double.parseDouble(consumo_total.getText().toString().trim());
        int couvertArtistico = Integer.parseInt(couvert_artistico.getText().toString().trim());
        int qtPessoas = Integer.parseInt(dividir_conta_por.getText().toString().trim());

        double taxaServico = calcTaxaServico(consumoTotal);
        taxa_servico.setText(String.valueOf(taxaServico));

        double valorContaFinal = calcContaTotal(consumoTotal, couvertArtistico, taxaServico);
        conta_total.setText(String.valueOf(valorContaFinal));

        double valorContaPorPessoa = calcValorPorPessoa(valorContaFinal, qtPessoas);
        valor_conta_pessoa.setText(String.valueOf(valorContaPorPessoa));
    }


    public double calcContaTotal(double consumoTotal, int couvertArtistico, double taxaServico) {
        return consumoTotal + couvertArtistico + taxaServico ;
    }

    public double calcValorPorPessoa(double contaTotal, int qtPessoas) {
        return contaTotal / qtPessoas ;
    }

    public double calcTaxaServico(double consumoTotal) {
        return consumoTotal / 10 ;
    }
}
