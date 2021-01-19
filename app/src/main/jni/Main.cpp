#include <string.h>
#include <jni.h>
#include "obfuscate.h"

extern "C"
{
	JNIEXPORT jobjectArray  JNICALL Java_net_bymodz_Native_StringArray(
        JNIEnv *env,jobject activityObject) {
     
     jobjectArray ret;

    const char *features[] = {
		
		OBFUSCATE("BYModZ • FFX"),
        
		OBFUSCATE("ANTENA HEAD"),
		OBFUSCATE("ANTENA HAND"),
		OBFUSCATE("× ANTENA OFF ×"),
		OBFUSCATE("© 2021 BY ModZ"),
        OBFUSCATE("fonts/ffx.otf"),
        
        OBFUSCATE("plugins/68~65~61~64.unity3D"),
        OBFUSCATE("plugins/68~61~6e~64.unity3D"),
        OBFUSCATE("plugins/62~61~63~6b~75~70.unity3D"),
        
        OBFUSCATE("/Android/data/com.dts.freefireth/files/ymrtc_log.txt"),
        OBFUSCATE("/Android/data/com.dts.freefireth/files/reportnew.db"),
        OBFUSCATE("/Android/data/com.dts.freefireth/files/contentcache/Compulsory/android/gameassetbundles/avatar/assetindexer.8~2FDinOIgg9lz07Rd~2BaRxwEkU4yw~3D"),
        
        OBFUSCATE("About app"),
        OBFUSCATE("Check update"),
        OBFUSCATE("Clear log"),
        
        OBFUSCATE("https://youtube.com/channel/UCjL4DdijT8ZIkky7Osl9eVg"),
        OBFUSCATE("FFX version 1.3\nFor more information check my channel.\n\nBY ModZ"),
        OBFUSCATE("===="),
        
		};
			
    int Total_Feature = (sizeof features /
                         sizeof features[0]);

    ret = (jobjectArray) env->NewObjectArray(Total_Feature, env->FindClass("java/lang/String"),
                                             env->NewStringUTF(""));
    int i;
    for (i = 0; i < Total_Feature; i++)
        env->SetObjectArrayElement(ret, i, env->NewStringUTF(features[i]));
    return (ret);
    
	}
	
    void MakeToast(JNIEnv *env, jobject thiz, const char *text, int length) {
    jstring jstr = env->NewStringUTF(text); 
    jclass toast = env->FindClass(OBFUSCATE("android/widget/Toast"));
    jmethodID methodMakeText =
            env->GetStaticMethodID(
                    toast,
                    OBFUSCATE("makeText"),
                    OBFUSCATE(
                            "(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;"));
    if (methodMakeText == NULL) {
        // noop
        return;
    }
    jobject toastobj = env->CallStaticObjectMethod(toast, methodMakeText,
                                                   thiz, jstr, length);

    jmethodID methodShow = env->GetMethodID(toast, OBFUSCATE("show"), OBFUSCATE("()V"));
    if (methodShow == NULL) {
       // noop
        return;
    }
    env->CallVoidMethod(toastobj, methodShow);
    }
  
    JNIEXPORT void JNICALL Java_net_bymodz_Native_T(JNIEnv *env, jclass obj, jobject context, jint numOfMessage) {
    if (numOfMessage == 0){
        MakeToast(env, context, OBFUSCATE("BYModZ • FFX"),1);
    }
    if (numOfMessage == 1){
        MakeToast(env, context, OBFUSCATE("ANTENA HEAD ON ✓"), 1);
    }
    if (numOfMessage == 2){
        MakeToast(env, context, OBFUSCATE("ANTENA HAND ON ✓"), 1);
    }
    if (numOfMessage == 3){
        MakeToast(env, context, OBFUSCATE("ANTENA OFF ✓"),1);
    }
    if (numOfMessage == 4){
        MakeToast(env, context, OBFUSCATE(" Clear Log Done ✓"),1);
    }
    }
}
