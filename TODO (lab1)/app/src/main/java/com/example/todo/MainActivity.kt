package com.example.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPresenter(MainPresenter(this, DependencyInjectorImpl()))
        presenter.onViewCreated()
    }

    override fun displayTODOList(items: ArrayList<TODOItem>) {
        val bundle = Bundle()
        bundle.putParcelableArrayList("items", items)

        val fragment = ListFragment()
        fragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.main, fragment)
            .commit()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }
}