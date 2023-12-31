package id.ac.ukdw.kruidentapps.untils

sealed class Results {
    data class Success<out T>(val data: T) : Results()
    data class Error(val exception: Throwable) : Results()
    data class Loading(val isLoading: Boolean) : Results()
}