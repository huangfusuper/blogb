package com.blog;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestList {
    @Test
    public void test(){
        List<String> list = testPage(3, 10);
        for (String s : list) {
            System.out.print(s+"\t");
        }
    }

    public List<String> testPage(Integer pageNo,Integer pageSize){
        List<String> list = setList();
        //计算出其实条数 比如一页十条0-20即使三页   比如第一页就是0-9    第二页就是 10-19  第三页  20
        //以下全部按照 第一页  每页10条数据举例

        //计算起始条数 当前页*每页显示条数    （1-1）*10   = 0
        Integer startIndex = (pageNo-1)*pageSize;
        //计算结束条数  0+10 = 10        开始为0结束为10   0---10  这里算出10条是因为  sublist()方法会将最后一个忽略
        Integer endIndex = startIndex+pageSize;
        //如果总条数小于结束条数  重新赋值为 集合长度最大值
        if(endIndex>list.size()){
            endIndex = list.size();
        }

        //0---10   不包括最后一个   0---9
        List<String> subList = list.subList(startIndex, endIndex);
        return subList;

    }


    /**
     * 你不用管   我模拟20条数据  从0-20
      * @return
     */
    private List<String> setList(){
        String[] strs = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
        List<String> list = Arrays.asList(strs);
        return list;
    }
}
