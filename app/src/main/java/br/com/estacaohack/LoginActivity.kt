package br.com.estacaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Executar o clique do botão entrar
        btnLoginEntrar.setOnClickListener {

            //Input data
            val email = edtLoginEmail.text.toString().trim().toLowerCase()
            val senha = edtLoginSenha.text.toString().trim()

            //Validations
            if(email.isEmpty()){
                edtLoginEmail.error = "Campo obrigatório."
                edtLoginEmail.requestFocus()
            } else if (senha.isEmpty()){
                edtLoginSenha.error = "Campo obrigatório."
                edtLoginSenha.requestFocus()
            } else {
                //Acessando o arquivo de preferências compartilhadas
                val sharedPrefs = getSharedPreferences("cadastro_$email", Context.MODE_PRIVATE)

                //Recuperando dados de Shared Preferences
                val emailPrefs = sharedPrefs.getString("EMAIL", "")
                val senhaPrefs = sharedPrefs.getString("SENHA", "")

                //Verificando o email que o usuário
                if (email == emailPrefs && senha == senhaPrefs) {
                    Toast.makeText(this, "Usuário logado com sucesso", Toast.LENGTH_LONG).show()

                    //Abrindo a Main Activity
                    val mIntent = Intent(this, MainActivity::class.java)

                    //Passando informações através do Intent
                    mIntent.putExtra("INTENT_EMAIL", email)
                    startActivity(mIntent)
                    finish()
                } else {
                    //Showing error message to user
                    Toast.makeText(this, "E-mail ou senha inválidos.", Toast.LENGTH_LONG).show()
                }
            }
        }

        //Executar o clique do botão cadastrar
        btnLoginCadastrar.setOnClickListener {
            //Abrindo a tela de cadastro
            val mIntent = Intent(this, CadastroActivity::class.java)
            startActivity(mIntent)
            finish()
        }
    }
}