package com.example.moviesapp.presentation.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviesapp.domain.model.Movie
import com.example.moviesapp.domain.usecase.GetListMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val getListMoviesUseCase: GetListMoviesUseCase
): ViewModel(){

    private val _listMovies = MutableLiveData<List<Movie>>()
    val listMovies: LiveData<List<Movie>> get() = _listMovies

    init {
        getList()
    }

    private fun getList(){
        viewModelScope.launch {
            val result = getListMoviesUseCase.invoke()
            _listMovies.postValue(result!!)
            Log.i("result: ", result.toString())
        }
    }

}