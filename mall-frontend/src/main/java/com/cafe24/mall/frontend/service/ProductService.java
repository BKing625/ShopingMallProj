package com.cafe24.mall.frontend.service;

import com.cafe24.mall.frontend.dto.ProductDto;
import com.cafe24.mall.frontend.vo.OptionVo;
import com.cafe24.mall.frontend.vo.ProductVo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import okhttp3.*;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {


    public List<ProductVo> getList(Integer page){
        try {

            Request request = new Request.Builder()
                    .url("http://localhost:8081/product//list/"+page.toString())
                    .addHeader("content-type", "application/json")
                    .get()
                    .build();
            OkHttpClient client = new OkHttpClient();
            Response response = client.newCall(request).execute();

            if(!response.isSuccessful())
                return null;

            String resStr = new Gson().fromJson(response.body().string(),JsonObject.class).get("data").toString();
            Type typeToken = new TypeToken<ArrayList<ProductVo>>(){}.getType();
            //System.out.println(resStr);

            List<ProductVo> res = new Gson().fromJson(resStr,typeToken);

//            for (ProductVo vo : res){
//                System.out.println(vo);
//            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Boolean add(ProductDto productDto){

        ProductVo addVo = makeVo(productDto);
        try {

            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, new Gson().toJson(addVo));

            Request request = new Request.Builder()
                    .url("http://localhost:8081/product")
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







    private ProductVo makeVo(ProductDto productDto){
        // TODO: 2019-08-07 smells, terrible, horrible code
        ProductVo resVo = new ProductVo();

        resVo.setProductStockType(ProductVo.StockType.UNLIMIT);
        resVo.setProductName(productDto.getName());
        resVo.setProductTitle(productDto.getDetail());
        resVo.setProductPrice(productDto.getPrice());

        int layer = productDto.getOption_cnt();
        List<List<String>> detailList = new ArrayList<>();
        detailList.add(productDto.getOptionDetail_0());
        if(layer>1){
            detailList.add(productDto.getOptionDetail_1());
            if(layer>2){
                detailList.add(productDto.getOptionDetail_2());
                if(layer>3){
                    detailList.add(productDto.getOptionDetail_3());
                }
            }
        }
        OptionVo lstVo = new OptionVo();

        for(int i = 0; i<detailList.get(layer-1).size();i++){
            OptionVo vo = new OptionVo();
            vo.setOptionDetail(detailList.get(layer-1).get(i));

            lstVo.addChildren(vo);
        }
        Map<Integer, OptionVo> voMap = new HashMap<>();
        voMap.put(layer,lstVo);

        for(int i = layer; i>1;i--){

            OptionVo parVo = new OptionVo();
            for(int j = 0;j<detailList.get(i-2).size();j++){
                OptionVo vo = new OptionVo();
                vo.setOptionDetail(detailList.get(i-2).get(j));

                OptionVo subVo = voMap.get(i);
                vo.setSubOptions(subVo.getCopy().getSubOptions());
                parVo.addChildren(vo);
            }
            voMap.put(i-1,parVo);
        }
        OptionVo ovo = voMap.get(1);
        for(OptionVo vo : ovo.getSubOptions())
            resVo.addOption(vo);

        return resVo;
    }
}
