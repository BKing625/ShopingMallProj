package com.cafe24.mall.frontend.service;

import com.cafe24.mall.frontend.vo.BucketVo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class BucketService {

    public Boolean addItem (BucketVo bucVo){
        try {

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, new Gson().toJson(bucVo));

            Request request = new Request.Builder()
                    .url("http://localhost:8081/bucket")
                    .addHeader("content-type", "application/json")
                    .post(body)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            return response.isSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<BucketVo> getList(Long userNumber) {
        try {

            Request request = new Request.Builder()
                    .url("http://localhost:8081/bucket/user/"+userNumber.toString())
                    .addHeader("content-type", "application/json")
                    .get()
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful())
                return null;

            String resStr = new Gson().fromJson(response.body().string(), JsonObject.class).get("data").toString();
            Type typeToken = new TypeToken<List<BucketVo>>() {
            }.getType();
            //System.out.println(resStr);

            //List<BucketVo> res =

            return new Gson().fromJson(resStr, typeToken);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
