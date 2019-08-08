package com.cafe24.mall.frontend.service;

import com.cafe24.mall.frontend.vo.UserVo;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public Boolean join(UserVo regiVo){


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
}
