package com.designedbyz.covidreporter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.designedbyz.covidreporter.timessearch.Body
import com.designedbyz.covidreporter.timessearch.NytSearchService
import com.designedbyz.covidreporter.timessearch.NytSearchUseCase
import com.designedbyz.covidreporter.ui.HeadlineAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

//TODO use a more advanced framework, such as architecture components, or possibly something mvi like Square's workflow.
class MainActivity : AppCompatActivity(), Callback<Body> {

    @Inject lateinit var nytSearchUseCase: NytSearchUseCase
    @Inject lateinit var adapter: HeadlineAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (applicationContext as CovidApplication).applicationComponent.injectInto(this)
        article_recycler_view.layoutManager = LinearLayoutManager(this)
        article_recycler_view.adapter = adapter
        nytSearchUseCase.searchForCovidArticles(this)
    }

    override fun onResponse(call: Call<Body>, response: Response<Body>) {
        if (response.isSuccessful) {
            delight_spinner.visibility = View.GONE
            article_recycler_view.visibility = View.VISIBLE
            adapter.addArticles(response.body()!!.response.docs!!)
            adapter.notifyDataSetChanged()
        }
    }

    override fun onFailure(call: Call<Body>, t: Throwable) {
        Log.d(this::class.simpleName, "Error getting response", t)
        Toast.makeText(this, "oops", Toast.LENGTH_LONG)
    }
}
