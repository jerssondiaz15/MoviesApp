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

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> get() = _movie

    private val _page = MutableLiveData<Int>()
    val page: LiveData<Int> get() = _page

    init {
        _page.value = 1
        getList()
    }

    private fun getList(){
        viewModelScope.launch {
            val result = getListMoviesUseCase.invoke(_page.value!!)
            _listMovies.postValue(result)
            Log.i("result: ", result.toString())
        }
    }

    fun setMovie(movie: Movie){
        _movie.postValue(movie)
    }

    fun nextPage(){
        _page.postValue(_page.value!!.plus(1))
        getList()
    }

    fun previousPage(){
        _page.postValue(_page.value!!.minus(1))
        getList()
    }

}