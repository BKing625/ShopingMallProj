package com.cafe24.mall.frontend.service;

import com.cafe24.mall.frontend.vo.ProductVo;
import com.cafe24.mall.frontend.vo.UserVo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class UserService {

    public Boolean join(UserVo regiVo) {


        try {

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, new Gson().toJson(regiVo));

            Request request = new Request.Builder()
                    .url("http://localhost:8081/users")
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

    public List<UserVo> getList(Integer page) {
        try {
            Request request = new Request.Builder()
                    .url("http://localhost:8081/users/list/" + page.toString())
                    .addHeader("content-type", "application/json")
                    .get()
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful())
                return null;

            String resStr = new Gson().fromJson(response.body().string(), JsonObject.class).get("data").toString();
            Type typeToken = new TypeToken<List<UserVo>>() {
            }.getType();
            //System.out.println(resStr);

            List<UserVo> res = new Gson().fromJson(resStr, typeToken);

            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserVo login(String email, String password) {
        UserVo loginVo = new UserVo();
        loginVo.setUserId(email);
        loginVo.setUserPassword(password);
        try {
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, new Gson().toJson(loginVo));

            Request request = new Request.Builder()
                    .url("http://localhost:8081/users/login")
                    .addHeader("content-type", "application/json")
                    .post(body)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful())
                return null;

            String resStr = new Gson().fromJson(response.body().string(), JsonObject.class).get("data").toString();
            Type typeToken = new TypeToken<UserVo>() {
            }.getType();
            //System.out.println(resStr);

            UserVo res = new Gson().fromJson(resStr, typeToken);

            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
