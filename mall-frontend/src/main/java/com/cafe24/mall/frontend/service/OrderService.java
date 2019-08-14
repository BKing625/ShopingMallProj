package com.cafe24.mall.frontend.service;

import com.cafe24.mall.frontend.dto.ProductSimpleViewDto;
import com.cafe24.mall.frontend.vo.OrderDetailsVo;
import com.cafe24.mall.frontend.vo.OrderVo;
import com.cafe24.mall.frontend.vo.UserVo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public Long addOrder(OrderVo addVo){


        Long res=-1L;
        try {

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, new Gson().toJson(addVo));

            Request request = new Request.Builder()
                    .url("http://localhost:8081/order")
                    .addHeader("content-type", "application/json")
                    .post(body)
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();


            if (!response.isSuccessful())
                return res;

            String resOrderNum = new Gson().fromJson(response.body().string(), JsonObject.class).get("data").toString();
            res = Long.parseLong(resOrderNum);
            //addVo.getUserNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public List<OrderVo> getList(Long userNumber, Integer orderPage) {
        List<OrderVo> resList = null;
        try {

            Request request = new Request.Builder()
                    .url("http://localhost:8081/order/list/"+userNumber.toString()+"/"+orderPage.toString())
                    .addHeader("content-type", "application/json")
                    .get()
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful())
                return null;

            String resStr = new Gson().fromJson(response.body().string(), JsonObject.class).get("data").toString();
            Type typeToken = new TypeToken<List<OrderVo>>() {
            }.getType();
            //System.out.println(resStr);

            //List<BucketVo> res =
            resList = new Gson().fromJson(resStr, typeToken);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resList;
    }
    public OrderVo get(Long userNumber,Long orderNumber){

        try {

            Request request = new Request.Builder()
                    .url("http://localhost:8081/order/"+userNumber.toString()+"/"+orderNumber.toString())
                    .addHeader("content-type", "application/json")
                    .get()
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            if (!response.isSuccessful())
                return null;

            String resStr = new Gson().fromJson(response.body().string(), JsonObject.class).get("data").toString();
            Type typeToken = new TypeToken<OrderVo>() {
            }.getType();
            //System.out.println(resStr);

            //List<BucketVo> res =
            return new Gson().fromJson(resStr, typeToken);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public ProductSimpleViewDto getOrderDetails(Long orderNumber) {
        return null;
    }
}
