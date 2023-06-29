package com.dz.tmdbmobileapi.remote

import com.dz.tmdbmobileapi.Network
import com.dz.tmdbmobileapi.base.Resource
import com.dz.tmdbmobileapi.local.data.model.Failure
import com.dz.tmdbmobileapi.getNetwork
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.headers
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import kotlinx.serialization.json.Json

import io.ktor.serialization.kotlinx.json.*


object NetworkClient {
    private val network: Network = getNetwork()

    val httpClient = network.httpClient {
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println("Logger Ktor => $message")
                }
            }
            level = LogLevel.ALL
        }

        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }

        install(ResponseObserver) {
            onResponse { response ->
                println("Response :${response}")
            }
        }

        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Any)
        }
    }

    suspend inline fun <reified T> HttpClient.safeGet(url: String, authHeader: String? = null): Resource<T> {
        return try {
            get(url){
                authHeader ?: return@get
                headers {
                    this.append(HttpHeaders.Authorization, authHeader)
                }
            }.toResponse<T>()
        } catch (e: Exception) {
            if (e.message?.contains("unable to resolve host", true) == true) {
                Resource.error(Failure.HttpErrorUnreachableServer(e))
            } else {
                Resource.error(Failure.GenericError(e))
            }
        } catch (e: Throwable) {
            Resource.error(Failure.HttpErrorUnreachableServer(e))
        }
    }
}


suspend inline fun <reified T> HttpResponse.toResponse(): Resource<T> {
    return when (status.value) {
        in 200..226 -> Resource.success(body())

        in 300..399 -> Resource.error(
            Failure.HttpErrorRedirectResponseException(
                RedirectResponseException(this, "Redirect response exception.")
            )
        )
        in 400..499 -> Resource.error(
            Failure.HttpErrorRedirectResponseException(
                RedirectResponseException(this, "Redirect response exception.")
            )
        )
        400 -> Resource.error(
            Failure.HttpErrorBadRequest(
                ClientRequestException(this, "Bad Request response exception.")
            )
        )
        401 -> Resource.error(
            Failure.HttpErrorUnauthorized(
                ClientRequestException(this, "Bad Request response exception.")
            )
        )
        403 -> Resource.error(
            Failure.HttpErrorForbidden(
                ClientRequestException(this, "Forbidden Exception due to roles.")
            )
        )
        404 -> Resource.error(
            Failure.HttpErrorNotFound(
                ClientRequestException(this, "End point not found.")
            )
        )
        in 500..599 -> Resource.error(
            Failure.HttpErrorInternalServer(
                ServerResponseException(this, "Internal server error.")
            )
        )
        else -> {
            Resource.error(
                Failure.HttpErrorInternalServer(
                    ServerResponseException(this, "Internal server error.")
                )
            )
        }
    }
}