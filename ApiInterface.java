package com.example.lore;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("gettable.php")

    Call<List<Table>> gettable (@Query("key") String keyword);

}

