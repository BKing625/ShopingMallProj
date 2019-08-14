package com.cafe24.mall.frontend.util;

import com.cafe24.mall.frontend.vo.OptionVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MallUtil {


    public static String optionStringMaker(List<OptionVo> options, Long findOptionNumber){
        List<String> resStrList = new ArrayList<>();

        Stack<OptionVo> treeStack = new Stack<>();

        for(OptionVo option : options)
            treeStack.push(option);
        List<OptionVo> optionList = new ArrayList<>();
        while (!treeStack.isEmpty()){

            OptionVo oVo = treeStack.pop();
            optionList.add(oVo);

            if(oVo.getSubOptions()==null)
                continue;

            for(OptionVo subOption : oVo.getSubOptions()){
                treeStack.push(subOption);
            }

        }
        Boolean flag=true;
        while (flag) {
            for (OptionVo viewOption : optionList) {
                if(viewOption.getOptionNumber().equals(findOptionNumber)){
                    resStrList.add(viewOption.getOptionDetail());
                    findOptionNumber = viewOption.getParentOptionNumber();
                    if(findOptionNumber==null)
                        flag = false;
                    break;
                }
            }
        }

        String resStr= "";
        for(int i = resStrList.size();i>0;i--){
            resStr += resStrList.get(i-1) +"/";
        }
        return resStr;
    }
}
