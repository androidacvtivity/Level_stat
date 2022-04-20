package com.bancusoft.levelstat.Retrofit;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Let's Create an interface
 */
public interface RestApi {

    /**
     * This method will allow us perform a HTTP GET request to the specified url
     * .The response will be a ResponseModel object.
     */
    @GET("index.php")
    Call<ResponseModel> retrieve();

    @GET("index_view.php")
    Call<ResponseModelvw> retrievevw();

    @GET("index_caem.php")
    Call<ResponseModelcaem> retrievecaem();

    @GET("index_cuatm.php")
    Call<ResponseModelcu> retrievecu();



    @GET("index_cfp.php")
    Call<ResponseModelcfp> retrievecfp();




    @GET("index_cl_cuatm.php")
    Call<ResponseModelcuatm> retrievecuatm();


    @GET("index_cl_caem2.php")
    Call<ResponseModelcaem2cl> retrievecaem2cl();

    @GET("index_cl_caem.php")
    Call<ResponseModelcaemcl> retrievecaemcl();


    @GET("index_cl_cfoj.php")
    Call<ResponseModelCl_cfoj> retrieveclcfoj();


    @GET("index_cl_cocm.php")
    Call<ResponseModelCl_cocm> retrieveclcocm();

    @GET("index_cl_cfp.php")
    Call<ResponseModelCl_cfp> retrieveclcfp();

    @GET("index_cl_servicii.php")
    Call<ResponseModelCl_servicii> retrieveclservicii();


    @GET("index_cl_tari.php")
    Call<ResponseModelCl_tari> retrievecltari();


    @GET("index_cl_prodmold.php")
    Call<ResponseModelCl_prodmold> retrieveclprodmold();

    @GET("index_cl_medicament.php")
    Call<ResponseModel_Cl_medicament> retrievecl_medicament();


    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index.php")
    Call<ResponseModel> search(@Field("action") String action,
                               @Field("query") String query,
                               @Field("start") String start,
                               @Field("limit") String limit);


    @FormUrlEncoded
    @POST("index.php")
    Call<ResponseModel> search_dgti(@Field("action") String action,
                               @Field("query") String query,
                               @Field("start") String start,
                               @Field("limit") String limit);


    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_view.php")
    Call<ResponseModelvw> searchvw(@Field("actionvw") String actionvw,
                               @Field("queryvw") String queryvw,
                               @Field("startvw") String startvw,
                               @Field("limitvw") String limitvw);


    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cuatm.php")
    Call<ResponseModelcu> searchcu(@Field("actioncu") String actioncu,
                                   @Field("querycu") String querycu,
                                   @Field("startcu") String startcu,
                                   @Field("limitcu") String limitcu);


    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_caem.php")
    Call<ResponseModelcaem> searchcaem(@Field("actioncu") String actioncu,
                                   @Field("querycu") String querycu,
                                   @Field("startcu") String startcu,
                                   @Field("limitcu") String limitcu);

    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_cuatm.php")
    Call<ResponseModelcuatm> search_cl_cuatm_all(@Field("actioncu") String actioncu,
                                       @Field("querycu") String querycu,
                                       @Field("startcu") String startcu,
                                       @Field("limitcu") String limitcu);


    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_caem2.php")
    Call<ResponseModelcaem2cl> search_caem2(@Field("actioncu") String actioncu,
                                     @Field("querycu") String querycu,
                                     @Field("startcu") String startcu,
                                     @Field("limitcu") String limitcu);


    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_caem.php")
    Call<ResponseModelcaemcl> search_caem(@Field("actioncu") String actioncu,
                                            @Field("querycu") String querycu,
                                            @Field("startcu") String startcu,
                                            @Field("limitcu") String limitcu);



    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cfp.php")
    Call<ResponseModelcfp> searchcfp(@Field("actioncu") String actioncu,
                                     @Field("querycu") String querycu,
                                     @Field("startcu") String startcu,
                                     @Field("limitcu") String limitcu);





    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_cfoj.php")
    Call<ResponseModelCl_cfoj> search_cl_cfoj(@Field("actioncu") String actioncu,
                                     @Field("querycu") String querycu,
                                     @Field("startcu") String startcu,
                                     @Field("limitcu") String limitcu);



    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_cocm.php")
    Call<ResponseModelCl_cocm> search_cl_cocm(@Field("actioncu") String actioncu,
                                              @Field("querycu") String querycu,
                                              @Field("startcu") String startcu,
                                              @Field("limitcu") String limitcu);



    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_cfp.php")
    Call<ResponseModelCl_cfp> search_cl_cfp(@Field("actioncu") String actioncu,
                                            @Field("querycu") String querycu,
                                            @Field("startcu") String startcu,
                                            @Field("limitcu") String limitcu);


    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_servicii.php")
    Call<ResponseModelCl_servicii> search_cl_servicii(@Field("actioncu") String actioncu,
                                            @Field("querycu") String querycu,
                                            @Field("startcu") String startcu,
                                            @Field("limitcu") String limitcu);


    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_tari.php")
    Call<ResponseModelCl_tari> search_cl_tari(@Field("actioncu") String actioncu,
                                                      @Field("querycu") String querycu,
                                                      @Field("startcu") String startcu,
                                                      @Field("limitcu") String limitcu);



    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_prodmold.php")
    Call<ResponseModelCl_prodmold> search_cl_prodmold(@Field("actioncu") String actioncu,
                                              @Field("querycu") String querycu,
                                              @Field("startcu") String startcu,
                                              @Field("limitcu") String limitcu);




    /**
     * This method will allow us to search our data while paginating the search results. We
     * specify the search and pagination parameters as fields.
     */
    @FormUrlEncoded
    @POST("index_cl_medicament.php")
    Call<ResponseModel_Cl_medicament> search_cl_medicament(@Field("actioncu") String actioncu,
                                                      @Field("querycu") String querycu,
                                                      @Field("startcu") String startcu,
                                                      @Field("limitcu") String limitcu);


}
//end
