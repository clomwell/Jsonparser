package com.oioio.jsonparser;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView rtv = (TextView) findViewById(R.id.rtv);
        String strJson="[{name:Obama, math:50, phone: {mobile:111-1111, home:222-2222}},\n"
                + "{name:Psy, math:70, phone: {mobile:333-3333, home:444-4444}},\n"
                + "{name:Yuna, math:65, phone: {mobile:555-5555, home:666-6666}}]";
        String data = "";
        try {
            JSONArray jsonArray = new JSONArray(strJson);
            //jsonarray객체를 생성

            for(int i=0; i < jsonArray.length(); i++){

                JSONObject student = jsonArray.getJSONObject(i);
                // 객체에서 하위 객체를 추출
                JSONObject phone = student.getJSONObject("phone");
                // 하위 객체에서 데이터를 추출
                data += student.getString("name") + " - " + phone.getString("mobile") + " - " + phone.getString("home") + "\n";
            }
            rtv.setText(data);
        } catch (JSONException e) {e.printStackTrace();}
    }
}
