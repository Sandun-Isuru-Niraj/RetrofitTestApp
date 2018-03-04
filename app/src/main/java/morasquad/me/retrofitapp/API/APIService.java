package morasquad.me.retrofitapp.API;



import morasquad.me.retrofitapp.Model.Result;
import morasquad.me.retrofitapp.Model.Login;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Sandun Isuru Niraj on 3/4/2018.
 */

public interface APIService {


    @FormUrlEncoded
    @POST("appreg2")
    Call<Result> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("applogin2")
    Call <Login> loginUser(
           @Field("email") String email,
           @Field("password") String password
    );
}
