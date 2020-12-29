package com.fc.msp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Filter;

/**
 * @ClassName QianTest
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/10/10 9:15 下午
 * @Version 1.0
 */
public class QianTest {

    public static void main( String[] args ) {
        long startTime=System.currentTimeMillis(); //获取开始时间
        long endTime = 0L;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss.SSS");
        String formatStr =formatter.format(new Date());
        Boolean t=false;
        Boolean asd=false;
        System.out.println("开始时间：" +formatStr );
        String str ="{\"fields\":[\"cust_no\"],\"filterGroup\":{\"symbol\":\"and\",\"filters\":[],\"children\":[{\"symbol\":\"or\",\"filters\":[{\"dimName\":\"出生月份\",\"dimId\":\"birth_month\",\"valueList\":[\"4\"],\"type\":\"equal\",\"id\":\"\",\"classify\":\"02\",\"dataDate\":0,\"timeType\":true,\"staticVal\":\"\",\"dataName\":\"当前月份\",\"yearValue\":\"\",\"dynamicValue\":0,\"timeTitle\":true,\"colName\":\"birth_month\"},{\"dimName\":\"婚姻状况\",\"dimId\":\"marriage_stat_cd\",\"valueList\":[\"00\"],\"type\":\"equal\",\"id\":\"\",\"classify\":\"02\",\"dataDate\":0,\"timeType\":true,\"staticVal\":\"\",\"dataName\":\"当前月份\",\"yearValue\":\"\",\"dynamicValue\":0,\"timeTitle\":true,\"colName\":\"marriage_stat_cd\"}],\"children\":[],\"location\":\"10\"},{\"symbol\":\"and\",\"filters\":[{\"dimName\":\"性别\",\"dimId\":\"gender_cd\",\"valueList\":[\"O\"],\"type\":\"equal\",\"id\":\"\",\"classify\":\"02\",\"dataDate\":0,\"timeType\":true,\"staticVal\":\"\",\"dataName\":\"当前月份\",\"yearValue\":\"\",\"dynamicValue\":0,\"timeTitle\":true,\"colName\":\"gender_cd\"},{\"dimName\":\"年龄\",\"dimId\":\"age\",\"valueList\":[1],\"type\":\"greater\",\"id\":\"\",\"classify\":\"03\",\"dataDate\":0,\"timeType\":true,\"staticVal\":\"\",\"dataName\":\"当前月份\",\"yearValue\":\"\",\"dynamicValue\":0,\"timeTitle\":true,\"colName\":\"age\"}],\"children\":[],\"location\":\"11\"}],\"location\":\"0\"},\"fieldsDataDate\":\"20200414\",\"fieldTimeType\":false}";
        JSONObject jb = JSON.parseObject(str);
        endTime = System.currentTimeMillis();
        System.out.println("字符串处理时间： "+(endTime-startTime)+"ms");
        JSONObject filterGroup = jb.getJSONObject("filterGroup");
        String s = filterGroup.getString("symbol");
        JSONArray filters = filterGroup.getJSONArray("filters");
        JSONArray children = filterGroup.getJSONArray("children");
        if(children.size()>0){
            Filters file =new Filters();
            String strlist = JSON.toJSONString(children);
            List<HashMap> list =JSON.parseArray(strlist, HashMap.class);
            HashMap<String ,Object> m =new HashMap<>();
            m.put("birth_month","1");
            m.put("marriage_stat_cd","00");
            m.put("gender_cd","O");
            m.put("age",12);
            for (Map<String,Object> hashMap : list) {
                String symbol = (String) hashMap.get("symbol");
                List<Filters> flist =new ArrayList<>();
                flist = (List<Filters>) hashMap.get("filters");
                JSONArray array= JSONArray.parseArray(JSON.toJSONString(flist));
                for (int i = 0; i < array.size(); i++) { //循环标签组中每个基础标签的具体匹配
                    JSONObject jsonObject=array.getJSONObject(i);
                    if(symbol.equals("or")){
                        if(jsonObject.getString("type").equals("equal")){
                            if (m.get(jsonObject.getString("colName")) != null && !m.get(jsonObject.getString("colName")).equals("")) {
                                String strp=jsonObject.getString("colName");
                                String a= (String) m.get(strp);
                                JSONArray asdasd=jsonObject.getJSONArray("valueList");
                                for (int j = 0; j < asdasd.size();j++) {
//提取出family中的所有
                                    String s1 = (String) asdasd.get(j);
                                    if(a.equals(s1)){
                                        t = true;
                                    }
                                }


                            }
                        }else if(jsonObject.getString("type").equals("no_equal")){

                        }
                        if(t==true){
                            break;
                        }
                    }else if(symbol.equals("and")){
                        if(jsonObject.getString("type").equals("equal")){
                            if ((m.get(jsonObject.getString("colName")) != null && !m.get(jsonObject.getString("colName")).equals(""))) {
                                String strp=jsonObject.getString("colName");
                                String a= (String) m.get(strp);
                                JSONArray asdasd=jsonObject.getJSONArray("valueList");
                                for (int j = 0; j < asdasd.size();j++) {
//
                                    String s1 = (String) asdasd.get(j);
                                    if(a.equals(s1)){
                                        t = true;
                                    }else{
                                        t = false;

                                    }

                                }

                            }else{
                                t = false;
                                break;
                            }
                        }else if(jsonObject.getString("type").equals("greater")){
                            if ((m.get(jsonObject.getString("colName")) != null && !m.get(jsonObject.getString("colName")).equals(""))) {
                                String strp=jsonObject.getString("colName");
                                int a= (int) m.get(strp);
                                JSONArray asdasd=jsonObject.getJSONArray("valueList");
                                for (int j = 0; j < asdasd.size();j++) {
                                    int s1 = (int) asdasd.get(j);
                                    if(a>s1){
                                        t = true;
                                    }else{
                                        t = false;
                                    }
                                }
                            }else{
                                t = false;
                                break;
                            }
                        }
                        if(t==false){
                            break;
                        }
                    }
                }
                if(s.equals("and") && t==true){
                    asd=true;
                }else{
                    asd=false;
                    break;
                }
                if(s.equals("or") && t==true){
                    asd=true;
                    break;
                }
            }
            if(asd==true){
                System.out.println("匹配成功");

            }else{
                System.out.println("匹配失败");
            }
        }

        endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
    public static class Filters{
        private String dimName;
        private String dimId;
        private String valueList;
        private String type;
        private String id;
        private String classify;
        private String dataDate;
        private String timeType;
        private String staticVal;
        private String dataName;
        private String yearValue;
        private String dynamicValue;
        private String timeTitle;
        private String colName;

        /**
         * Gets the value of dimName. *
         *
         * @return the value of dimName
         */
        public String getDimName() {
            return dimName;
        }

        /**
         * Sets the dimName. *
         * <p>You can use getDimName() to get the value of dimName</p>
         * * @param dimName dimName
         */
        public void setDimName(String dimName) {
            this.dimName = dimName;
        }

        /**
         * Gets the value of dimId. *
         *
         * @return the value of dimId
         */
        public String getDimId() {
            return dimId;
        }

        /**
         * Sets the dimId. *
         * <p>You can use getDimId() to get the value of dimId</p>
         * * @param dimId dimId
         */
        public void setDimId(String dimId) {
            this.dimId = dimId;
        }

        /**
         * Gets the value of valueList. *
         *
         * @return the value of valueList
         */
        public String getValueList() {
            return valueList;
        }

        /**
         * Sets the valueList. *
         * <p>You can use getValueList() to get the value of valueList</p>
         * * @param valueList valueList
         */
        public void setValueList(String valueList) {
            this.valueList = valueList;
        }

        /**
         * Gets the value of type. *
         *
         * @return the value of type
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the type. *
         * <p>You can use getType() to get the value of type</p>
         * * @param type type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         * Gets the value of id. *
         *
         * @return the value of id
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the id. *
         * <p>You can use getId() to get the value of id</p>
         * * @param id id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * Gets the value of classify. *
         *
         * @return the value of classify
         */
        public String getClassify() {
            return classify;
        }

        /**
         * Sets the classify. *
         * <p>You can use getClassify() to get the value of classify</p>
         * * @param classify classify
         */
        public void setClassify(String classify) {
            this.classify = classify;
        }

        /**
         * Gets the value of dataDate. *
         *
         * @return the value of dataDate
         */
        public String getDataDate() {
            return dataDate;
        }

        /**
         * Sets the dataDate. *
         * <p>You can use getDataDate() to get the value of dataDate</p>
         * * @param dataDate dataDate
         */
        public void setDataDate(String dataDate) {
            this.dataDate = dataDate;
        }

        /**
         * Gets the value of timeType. *
         *
         * @return the value of timeType
         */
        public String getTimeType() {
            return timeType;
        }

        /**
         * Sets the timeType. *
         * <p>You can use getTimeType() to get the value of timeType</p>
         * * @param timeType timeType
         */
        public void setTimeType(String timeType) {
            this.timeType = timeType;
        }

        /**
         * Gets the value of staticVal. *
         *
         * @return the value of staticVal
         */
        public String getStaticVal() {
            return staticVal;
        }

        /**
         * Sets the staticVal. *
         * <p>You can use getStaticVal() to get the value of staticVal</p>
         * * @param staticVal staticVal
         */
        public void setStaticVal(String staticVal) {
            this.staticVal = staticVal;
        }

        /**
         * Gets the value of dataName. *
         *
         * @return the value of dataName
         */
        public String getDataName() {
            return dataName;
        }

        /**
         * Sets the dataName. *
         * <p>You can use getDataName() to get the value of dataName</p>
         * * @param dataName dataName
         */
        public void setDataName(String dataName) {
            this.dataName = dataName;
        }

        /**
         * Gets the value of yearValue. *
         *
         * @return the value of yearValue
         */
        public String getYearValue() {
            return yearValue;
        }

        /**
         * Sets the yearValue. *
         * <p>You can use getYearValue() to get the value of yearValue</p>
         * * @param yearValue yearValue
         */
        public void setYearValue(String yearValue) {
            this.yearValue = yearValue;
        }

        /**
         * Gets the value of dynamicValue. *
         *
         * @return the value of dynamicValue
         */
        public String getDynamicValue() {
            return dynamicValue;
        }

        /**
         * Sets the dynamicValue. *
         * <p>You can use getDynamicValue() to get the value of dynamicValue</p>
         * * @param dynamicValue dynamicValue
         */
        public void setDynamicValue(String dynamicValue) {
            this.dynamicValue = dynamicValue;
        }

        /**
         * Gets the value of timeTitle. *
         *
         * @return the value of timeTitle
         */
        public String getTimeTitle() {
            return timeTitle;
        }

        /**
         * Sets the timeTitle. *
         * <p>You can use getTimeTitle() to get the value of timeTitle</p>
         * * @param timeTitle timeTitle
         */
        public void setTimeTitle(String timeTitle) {
            this.timeTitle = timeTitle;
        }

        /**
         * Gets the value of colName. *
         *
         * @return the value of colName
         */
        public String getColName() {
            return colName;
        }

        /**
         * Sets the colName. *
         * <p>You can use getColName() to get the value of colName</p>
         * * @param colName colName
         */
        public void setColName(String colName) {
            this.colName = colName;
        }
    }
}
