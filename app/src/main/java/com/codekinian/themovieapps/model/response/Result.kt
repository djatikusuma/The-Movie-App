package com.codekinian.themovieapps.model.response

import com.codekinian.themovieapps.utils.EspressoIdlingResource

data class Result<out T>(val status: Status, val data: T?, val message: String?) {

    enum class Status {
        SUCCESS,
        ERROR,
        LOADING
    }

    companion object {
        fun <T> success(data: T): Result<T> {
            EspressoIdlingResource.decrement()
            return Result(
                Status.SUCCESS,
                data,
                null
            )
        }

        fun <T> error(message: String, data: T? = null): Result<T> {
            EspressoIdlingResource.decrement()
            return Result(
                Status.ERROR,
                data,
                message
            )
        }

        fun <T> loading(data: T? = null): Result<T> {
            EspressoIdlingResource.decrement()
            return Result(
                Status.LOADING,
                data,
                null
            )
        }
    }
}