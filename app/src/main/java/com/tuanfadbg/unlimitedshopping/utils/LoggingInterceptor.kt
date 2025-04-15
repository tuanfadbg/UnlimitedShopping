package com.tuanfadbg.unlimitedshopping.utils

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody
import okio.Buffer
import java.io.IOException
import javax.inject.Inject

class LoggingInterceptor @Inject constructor(
    private val loggingPreferences: LoggingPreferences
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!loggingPreferences.isLoggingEnabled) {
            return chain.proceed(chain.request())
        }

        val request = chain.request()
        val requestBody = request.body

        // Log Request
        Log.d("API_LOG", "┌─────────────────────────────────────────────────────────────────────────")
        Log.d("API_LOG", "│ Request: ${request.method} ${request.url}")
        Log.d("API_LOG", "│ Headers: ${request.headers}")

        if (requestBody != null) {
            val buffer = Buffer()
            requestBody.writeTo(buffer)
            Log.d("API_LOG", "│ Request Body: ${buffer.readUtf8()}")
        }

        val response = chain.proceed(request)
        val responseBody = response.body
        val responseBodyString = responseBody?.string()

        // Log Response
        Log.d("API_LOG", "│ Response Code: ${response.code}")
        Log.d("API_LOG", "│ Response Headers: ${response.headers}")
        Log.d("API_LOG", "│ Response Body:")
        Log.d("API_LOG", "│ $responseBodyString")
        Log.d("API_LOG", "└─────────────────────────────────────────────────────────────────────────")

        // Recreate the response since we consumed the original response body
        return response.newBuilder()
            .body(ResponseBody.create(responseBody?.contentType(), responseBodyString ?: ""))
            .build()
    }
} 