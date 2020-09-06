package br.com.estacaohack

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        //Criando uma lista de opções para o Spinner
        val listaGenero = arrayListOf("Selecione o gênero", "Masculino", "Feminino", "Outros")

        //Criando um adapter para a list e o Spinner
        val generoAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            listaGenero
        )



        // Adicionar o adapter ao spinner
        spnCadastroGenero.adapter = generoAdapter

        //
        btnCadastroCadastrar.setOnClickListener {
            //Capturar os dados digitados
            val nome = edtCadastroNome.text.toString().trim()
            val sobrenome = edtCadastroSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim().toLowerCase(Locale.ROOT)
            val senha = edtCadastroSenha.text.toString().trim()

            val genero = spnCadastroGenero.selectedItem.toString()

            //Validação dos campos
            if (nome.isEmpty() || sobrenome.isEmpty() || email.isEmpty() || senha.isEmpty() || genero == listaGenero[0]) {

                //Apresentando um toast de erro ao usuário
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show()
            } else {
                //Todos os campos foram preenchidos


                //Criando ou acessando o arquivo de preferências compartilhadas
                val sharedPrefs = getSharedPreferences("cadastro_$email", MODE_PRIVATE)

                //Editar o arquivo de preferências compartilhadas
                val editPrefs = sharedPrefs.edit()

                //Preparando os dados a serem salvos no arquivo
                editPrefs.putString("NOME", nome)
                editPrefs.putString("SOBRENOME", sobrenome)
                editPrefs.putString("EMAIL", email)
                editPrefs.putString("SENHA", senha)
                editPrefs.putString("GENERO", genero)

                //Salvando os dados no arquivo Shared Preferences
                editPrefs.apply()

                //Abrindo a Main Activity
                val mIntent = Intent(this, MainActivity::class.java)

                //Passando informações através do Intent
                mIntent.putExtra("INTENT_EMAIL", email)
                startActivity(mIntent)

                //Tirando todas as telas do empilhamento
                finishAffinity()
            }
        }
    }
}