package com.example.taskapp.api;

import android.app.Activity;
import android.widget.Toast;

import com.example.taskapp.R;

import org.json.JSONObject;

public class APIErrorHandler {

    private static final APIErrorHandler ourInstance = new APIErrorHandler();

    public static APIErrorHandler getInstance() {
        return ourInstance;
    }

    private APIErrorHandler() {
    }

    public void errorHandler(Activity activity, int status_code, String message){
        switch (status_code){
            case 200:
                Toast.makeText(activity,message,Toast.LENGTH_LONG).show();
                break;
            case 201:
                Toast.makeText(activity,message,Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(activity,messageParsing(activity,message),Toast.LENGTH_LONG).show();
                break;
        }
    }

    private String messageParsing(Activity activity, String message){
        try {
            JSONObject jsonObject=new JSONObject(message);
            if (jsonObject.has("message")){
                return jsonObject.getString("message");
            }
        }catch (Exception e){
            return activity.getString(R.string.something_went_wrong_while_retrieving_information);
        }
        return activity.getString(R.string.something_went_wrong_while_retrieving_information);

    }

    public int messageParsing(String message){
        try {
            JSONObject jsonObject=new JSONObject(message);
            if (jsonObject.has("code")){
                return jsonObject.getInt("code");
            }
        }catch (Exception e){
            return 0;
        }
        return 0;
    }
}
