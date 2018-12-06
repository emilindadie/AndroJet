package com.example.emilin.androjet.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.emilin.androjet.R
import com.example.emilin.androjet.repository.UserServiceImpl
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.support.v4.toast
import io.reactivex.disposables.CompositeDisposable


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return LoginView().createView(AnkoContext.Companion.create(inflater.context, this, false))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

        view?.findViewById<Button>(R.id.loginButton)?.setOnClickListener {
            logUser();
        }
    }

    fun logUser(){

        if(view?.findViewById<EditText>(R.id.emailEditText)!!.text.isEmpty() && view?.findViewById<EditText>(R.id.passwordEditText)!!.text.isEmpty() ){
            Toast.makeText(this.context, "Hello, Tous les champs doivent etre remplis", Toast.LENGTH_LONG).show();
        }else{
            val mDisposable = CompositeDisposable()
            mDisposable.add( UserServiceImpl.getWebService().getProjectList("dadie.emilin@gmail.com", "azerty").observeOn(AndroidSchedulers.mainThread()).subscribeOn(
                Schedulers.io()).subscribe({
                Toast.makeText(this.context, "Sus", Toast.LENGTH_LONG).show();
                val user = it
                if(user != null){
                    Toast.makeText(this.context, "Good", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this.context, "Bad", Toast.LENGTH_LONG).show();
                }
            }))
            mDisposable.dispose(); // dispose wherever is required
        }
    }
}
