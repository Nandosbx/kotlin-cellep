package br.com.estacaohack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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
            android.R.layout.simple_spinner_dropdown_item,
            listaGenero
        )

        // Adicion ar o adapter ao spinner
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
            }
        }
    }
}