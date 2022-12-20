import com.android.advicezoid.model.Advices
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// Retrofit interface
interface RetrofitInterface {
    @GET("advice")
    suspend fun getAdvices() : Call<Advices>
}

// retrofit helper
object RetrofitHelper {
    val baseUrl = "https://api.adviceslip.com/"
    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}