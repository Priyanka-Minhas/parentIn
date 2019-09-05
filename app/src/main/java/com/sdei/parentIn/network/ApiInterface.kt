package com.sdei.parentIn.network

import com.sdei.parentIn.model.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @FormUrlEncoded
    @POST("/user/login")
    fun login(@Field("emailAddress") email: String,
              @Field("password") password: String,
              @Field("roleId") rollId: Int): Call<UserModel>

    @FormUrlEncoded
    @POST("/user/listBySchool")
    fun teacherListBySchool(@Field("school") school: String): Call<TeacherModel>

    @POST("/user/register")
    fun register(@Body userModel: UserModel.DataBeanRequest): Call<UserModel>

    // Get School List
    @GET("school/list")
    fun getSchoolList(): Call<SchoolModel>

    // Get child List
    @FormUrlEncoded
    @POST("/student/listByParent")
    fun getChildList(@Field("_id") _id: String): Call<ChildModel>


    //edit child
    @POST("/student/updateChildbyParent")
    fun updateChildbyParent(@Body child: ChildModel.DataBeanRequest
    ): Call<BaseModel>

    // add child
    @POST("/student/addChildbyParent")
    fun addChildbyParent(@Body child: ChildModel.DataBeanRequest
    ): Call<BaseModel>

    // get class list by teacher
    @FormUrlEncoded
    @POST("/student/listChildbyTeacher")
    fun getClassByTeacher(@Field("_id") id: String): Call<ClassModel>

    // add student manually by teacher

    @POST("/student/addStudentbyTeacher")
    fun addStudentByTeacher(@Body child: AddStudentManullyRequest
    ): Call<BaseModel>

    @GET("/survey/list2")
    fun getSurveyList(): Call<SurveysModel>

    @FormUrlEncoded
    @POST("/student/getSchoolListforSurvey")
    fun getSchoolListforSurvey(@Field("_id") _id: String):Call<SurveySchoolModel>

    @POST("/survey/saveSurvey")
    fun saveSurvey(@Body child: SurveysModel.DataBeanRequest): Call<BaseModel>

    @FormUrlEncoded
    @POST("/student/listChildbyTeacherCSV")
    fun getCSVFile(@Field("_id") _id: String):Call<ExportCsvModel>


    @Multipart
    @POST("/message/create")
    fun createMessage(attachment: MultipartBody.Part,
            @Part("to") to: List<RequestBody>,
            @Part("toName") toName: List<RequestBody>,
            @Part("from") from: RequestBody,
            @Part("fromName") fromName: RequestBody,
            @Part("message") message: RequestBody
    ): Call<MessagesModel>

//    @FormUrlEncoded
//    @POST("users/authenticate")
//    fun authenticate_user(
//        @Field("email") email: String,
//        @Field("password") password: String
//    ): Call<UserModel>
//
//
//    @FormUrlEncoded
//    @POST("users/current-user")
//    fun current_user(@Header("Authorization") authorization: String): Call<UserModel>
//
//
//    @FormUrlEncoded
//    @POST("users/confirm-registration")
//    fun confirm_registration(@Field("token") token: String): Call<UserModel>
//
//
//    @FormUrlEncoded
//    @POST("users/reset-password?")
//    fun reset_password(
//        @Field("resetToken") email: String,
//        @Field("password") password: String
//    ): Call<UserModel>
//
//
//    @FormUrlEncoded
//    @POST("users/forgot-password")
//    fun forgot_password(@Field("email") email: String): Call<UserModel>


    //    @GET
    //    public Call<GooglePlaceModal> getGooglePlaces(@Url String url);
    //
    //    @GET
    //    public Call<NearbyPlaceModel> getGoogleNearByPlaces(@Url String url);
    //
    //    @FormUrlEncoded
    //    @POST("phone_registration")
    //    Call<UserModel> phone_registration(@Field("login_via") String login_via,
    //                                       @Field("country_code") String country_code,
    //                                       @Field("phone_number") String phone_number,
    //                                       @Field("device_token") String device_token,
    //                                       @Field("device_type") String device_type);
    //


    //    @FormUrlEncoded
    //    @POST("social_login")
    //    Call<UserModel> social_login(@Field("login_via") String login_via,
    //                                 @Field("social_media_id") String country_code,
    //                                 @Field("device_token") String device_token,
    //                                 @Field("device_type") String device_type,
    //                                 @Field("name") String name,
    //                                 @Field("email") String email,
    //                                 @Field("profile_pic") String profile_pic);
    //
    //    @FormUrlEncoded
    //    @POST("get_all_deal")
    //    Call<DealModel> get_all_deal(@Field("access_token") String access_token,
    //                                 @Field("longitude") String longitude,
    //                                 @Field("latitude") String latitude,
    //                                 @Field("sort") String sort,
    //                                 @Field("store") String store_id,
    //                                 @Field("brand_id") String brand_id,
    //                                 @Field("max") String max,
    //                                 @Field("min") String min,
    //                                 @Field("offset") String offset,
    //                                 @Field("category") String category,
    //                                 @Field("search") String search,
    //                                 @Field("type") String type);
    //
    //    @FormUrlEncoded
    //    @POST("get_top_deal")
    //    Call<DealModel> get_top_deal(@Field("access_token") String access_token,
    //                                 @Field("longitude") String longitude,
    //                                 @Field("latitude") String latitude);
    //
    //    @Multipart
    //    @POST("create_profile")
    //    Call<UserModel> create_profile(@Part("name") RequestBody name,
    //                                   @Part("access_token") RequestBody access_token,
    //                                   @Part("email") RequestBody email,
    //                                   @Part MultipartBody.Part profile_pic);
    //
    //    @FormUrlEncoded
    //    @POST("get_brands")
    //    Call<FilterModel> get_brands(@Field("access_token") String access_token);
    //
    //    @FormUrlEncoded
    //    @POST("deal_detail_by_id")
    //    Call<DealModel> deal_detail_by_id(@Field("access_token") String access_token,
    //                                      @Field("deal_id") String deal_id);
    //
    //    @GET("get_category")
    //    Call<CategoryModel> get_category();
    //    @FormUrlEncoded
    //    @PUT("/api/user/getUserDocuments")
    //    Call<ActsModel> getActsUserDocuments(@Field("category") String category);
    //
    //    @FormUrlEncoded
    //    @PUT("/api/user/getUserDocuments")
    //    Call<BillsModel> getBillsUserDocuments(@Field("category") String category);
    //
    //    @GET("/api/user/getUserDirectory")
    //    Call<SenatorDetailModel> getUserDirectory();
    //
    //
    //    @FormUrlEncoded
    //    @PUT("/api/user/sendEmail")
    //    Call<SenatorDetailModel> sendEmail(@Field("senator") String senator,
    //                                       @Field("message") String message,
    //                                       @Field("NAME") String NAME,
    //                                       @Field("EMAIL") String EMAIL);
    //
    //    @GET
    //    Call<YoutubeModel> getYoutubeVideos(@Url String url);
    //


}
