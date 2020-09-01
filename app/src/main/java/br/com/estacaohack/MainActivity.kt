package br.com.estacaohack

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recuperar o email passado por meio da Intent
        val email = intent.getStringArrayExtra("INTENT_EMAIL")

        //Acessar o arquivo de preferências compartilhadas
        val sharedPrefs = getSharedPreferences(
            "cadastro_$email", //Nome do arquivo
            Context.MODE_PRIVATE //Modo de acesso
        )

        //Recuperar dados no arquivo de preferências compartilhadas
    }
}