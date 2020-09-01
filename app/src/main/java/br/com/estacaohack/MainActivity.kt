package br.com.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Recuperar o email passado por meio da Intent
        val email = intent.getStringExtra("INTENT_EMAIL")

        //Acessar o arquivo de preferências compartilhadas
        val sharedPrefs = getSharedPreferences(
            "cadastro_$email", //Nome do arquivo
            Context.MODE_PRIVATE //Modo de acesso
        )

        //Recuperar dados no arquivo de preferências compartilhadas
        val nome = sharedPrefs.getString("NOME", "")
        val sobrenome = sharedPrefs.getString("SOBRENOME", "")
        val genero = sharedPrefs.getString("GENERO", "")

        //Exibir os dados recuperados na tela
        txvMainName.text = "$nome $sobrenome"
        txvMainEmail.text = email
        txvMainGenero.text = genero

        // Escutando o clique do botão sair
        btnMainSair.setOnClickListener {

            //Criando uma caixa de diálogo
            val alert = AlertDialog.Builder(this)

            //Definindo um título
            alert.setTitle("App Estação Hack")

            //Definindo o corpo da mensagem
            alert.setMessage("Deseja sair?")

            //Definindo o rótulo do botão e escutando o seu clique
            alert.setPositiveButton("Sair") {
                dialog,wich ->
                val mIntent = Intent(this, LoginActivity::class.java)
                startActivity(mIntent)

                //Eliminado as telas da pilha
                finishAffinity()
            }

            //Definindo o rótulo do botão e escutando o seu clique
            alert.setNeutralButton("Não") { dialog, wich ->}

            //Exibindo a caixa de diálogo
            alert.show()
        }

        // Escutando o clique do botão Site Cellep
        btnMainSite.setOnClickListener {
            val mIntent = Intent (this, WebActivity::class.java)
            startActivity(mIntent)
        }
    }
}