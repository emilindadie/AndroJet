package com.example.emilin.androjet.ui.main


import com.example.emilin.androjet.R
import org.jetbrains.anko.*

class LoginView : AnkoComponent<MainFragment> {

    override fun createView(ui: AnkoContext<MainFragment>) = with(ui) {
        verticalLayout {
            lparams(width = matchParent, height = matchParent)
            editText {
                id = R.id.emailEditText
                hintResource = R.string.sign_in_email
                textSize = 24f
            }.lparams(width = matchParent, height = wrapContent)

            editText {
                id = R.id.passwordEditText
                hintResource = R.string.sign_in_password
                textSize = 24f
            }.lparams(width = matchParent, height = wrapContent)
            button("Connexion"){
                id = R.id.loginButton
            }
        }
    }
}