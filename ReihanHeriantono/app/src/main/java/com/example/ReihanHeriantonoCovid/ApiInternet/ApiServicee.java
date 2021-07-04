package com.example.ReihanHeriantonoCovid.ApiInternet;

import com.example.ReihanHeriantonoCovid.Pembantu.GetDataCovid;
import com.example.ReihanHeriantonoCovid.Pembantu.GetDataRS;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServicee {
    @GET("/api/v1/rekapitulasi_v2/jabar/harian")
    Call<GetDataCovid> getResources();

    @GET("/api/v1/sebaran_v2/jabar/faskes")
    Call<GetDataRS> getRumahSakit();
    //Call<getRepository> getRepositoryResources();

   // @FormUrlEncoded
    //@POST("repository")
    //Call<editRepository> post(@Field("nama") String nama,
                                        //@Field("nomor") String nomor);
    //@FormUrlEncoded
    //@PUT("kontak")
    //Call<editRepository> putKontak(@Field("id") String id,
                                     //@Field("nama") String nama,
                                     //@Field("nomor") String nomor);
    //@FormUrlEncoded
    //@HTTP(method = "DELETE", path = "kontak", hasBody = true)
    //Call<editRepository> deleteKontak(@Field("id") String id);
}
