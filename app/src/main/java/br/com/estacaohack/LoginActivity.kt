package br.com.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Executing the clicking button
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
                //Showing error message to user
                Toast.makeText(this, "E-mail ou senha inválidos.", Toast.LENGTH_LONG).show()
            }
        }
    }
}