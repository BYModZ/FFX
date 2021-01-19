package net.bymodz;

import android.content.Context;

public class Native {
    public Native(){
        System.loadLibrary("BYModZ");
    }
    
    public static native void T(Context context, int numOfMessage);
    public static native  String[]  StringArray();
    
    public static void mT(Context context, int numOfMessage) {
        T(context, numOfMessage);
    }

    public static String gS(int numOfString){
        String[] str = StringArray();
        return str[numOfString];
    }

}
