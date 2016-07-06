package iview.wsienski.androidtestintegration;

import android.content.Context;

/**
 * Created by Witold Sienski on 05.07.2016.
 */
public class Calculator {

    Context context;

    public Calculator(Context context) {
        this.context = context;
    }

    public void exampleMethod(){

    }

    public String getDefaultValue(){
        return  context.getString(R.string.app_name);
    }

    public static int sum(int num1, int num2){
        return num1 + num2;
    }
}
