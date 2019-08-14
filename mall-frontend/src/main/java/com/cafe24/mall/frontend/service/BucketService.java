package com.cafe24.mall.frontend.service;

import com.cafe24.mall.frontend.dto.ProductSimpleViewDto;
import com.cafe24.mall.frontend.util.MallUtil;
import com.cafe24.mall.frontend.vo.BucketVo;
import com.cafe24.mall.frontend.vo.ProductVo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
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

    public List<ProductSimpleViewDto> getList(Long userNumber) {
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
            List<BucketVo> bucketVoList = new Gson().fromJson(resStr, typeToken);
            if (bucketVoList == null) return null;

            List<ProductSimpleViewDto> resList = new ArrayList<>();
            for(BucketVo bucVo :bucketVoList){
                Request subRequest = new Request.Builder()
                        .url("http://localhost:8081/product/option/"+bucVo.getOptionNumber().toString())
                        .addHeader("content-type", "application/json")
                        .get()
                        .build();


                response = client.newCall(subRequest).execute();
                if (!response.isSuccessful())
                    return null;

                ProductSimpleViewDto dto = new ProductSimpleViewDto();
                String resStrSub = new Gson().fromJson(response.body().string(), JsonObject.class).get("data").toString();
                Type typeTokenSub = new TypeToken<ProductVo>() {
                }.getType();
                //System.out.println(resStr);

                ProductVo res = new Gson().fromJson(resStrSub, typeTokenSub);

                dto.setBucketNumber(bucVo.getBucketNumber());
                dto.setCount(bucVo.getBucketCount());
                dto.setOptionNumber(bucVo.getOptionNumber());
                dto.setOptionStr(MallUtil.optionStringMaker(res.getOptions(),bucVo.getOptionNumber()));
                dto.setProductName(res.getProductName());
                dto.setProductPrice(res.getProductPrice());
                dto.setProductNumber(res.getProductNumber());

                resList.add(dto);

            }
            return resList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean delete(Long userNumber, Long bucNum) {
        try {

            Request request = new Request.Builder()
                    .url("http://localhost:8081/bucket/"+bucNum.toString())
                    .addHeader("content-type", "application/json")
                    .delete()
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            return response.isSuccessful();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteByUser(Long userNumber) {
        try {

            Request request = new Request.Builder()
                    .url("http://localhost:8081/bucket/user/"+userNumber.toString())
                    .addHeader("content-type", "application/json")
                    .delete()
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
