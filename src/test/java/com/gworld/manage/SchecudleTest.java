package com.gworld.manage;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@ExtendWith(MockitoExtension.class)
class SchecudleTest {

    @Test
    void test2(){
//        Timestamp stamp = new Timestamp(System.currentTimeMillis());
//        Date date = new Date(1652025090);
//
//        LocalDateTime localDateTime = date.toInstant() // Date -> Instant
//                .atZone(ZoneId.systemDefault()) // Instant -> ZonedDateTime
//                .toLocalDateTime(); // ZonedDateTime -> LocalDateTime
//        System.out.println(localDateTime);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp); // 생성한 timestamp 출력

        SimpleDateFormat sdf = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(1652025090)); // format을 사용해 출력
        // https://m.bunjang.co.kr/search/products?order=price_asc&page=2&q=%EB%A7%A5%EB%B6%81%EC%97%90%EC%96%B4m1
    }
    // 1652025090
    // 1662021158166
    @Test
    void test(){
        try {
            String apiURL = "https://api.bunjang.co.kr/api/1/find_v2.json?q=%EB%A7%A5%EB%B6%81%EC%97%90%EC%96%B4m1&order=price_asc&page=1&request_id=2022901162628&stat_uid=80063034&stat_device=w&n=100&stat_category_required=1&req_ref=search&version=4";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
//            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response);
//            System.out.println(response.toString());

            JSONParser jsonPares = new JSONParser();
            JSONObject obj = (JSONObject)jsonPares.parse(response.toString());
            JSONArray jArray = (JSONArray) obj.get("list");
            System.out.println(jArray);

            for (Object o: jArray){
                JSONObject jo = (JSONObject) o;
                int price = Integer.parseInt(String.valueOf(jo.get("price")));
                String pid = String.valueOf(jo.get("pid"));
                if(price < 800000){
                    String urlReal = pid+"https://m.bunjang.co.kr/products/195257818?q=%EB%A7%A5%EB%B6%81%EC%97%90%EC%96%B4m1&ref=%EA%B2%80%EC%83%89%EA%B2%B0%EA%B3%BC";
                    System.out.println(LocalDateTime.now());
                    System.out.println(urlReal+"/"+price);
                    Date d = new Date();
                    System.out.println("d:"+d);
                }

            }
//            JSONArray parsedJsonArray = (JSONArray) parser.parse(response.toString());
//            System.out.println(parsedJsonArray.toString());
//            for (Object o: parsedJsonArray){
//                System.out.println(o);
//                JSONObject jo = (JSONObject) o;
//                System.out.println(jo.get("name"));
//            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
