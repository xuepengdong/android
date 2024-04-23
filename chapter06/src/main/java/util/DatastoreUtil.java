package util;

import android.content.Context;

import androidx.datastore.preferences.core.MutablePreferences;
import androidx.datastore.preferences.core.PreferencesKeys;
import androidx.datastore.preferences.rxjava2.RxPreferenceDataStoreBuilder;
import androidx.datastore.preferences.core.Preferences;
import androidx.datastore.rxjava2.RxDataStore;

import io.reactivex.Flowable;
import io.reactivex.Single;


public class DatastoreUtil {
    private RxDataStore<Preferences> mDataStore;
    private static DatastoreUtil instance;
    private  DatastoreUtil(Context context){
        mDataStore = new RxPreferenceDataStoreBuilder(context.getApplicationContext(), "datastore").build();
    }

    public static DatastoreUtil getInstance(Context context){
        if(instance == null){
            instance = new DatastoreUtil(context);
        }
        return instance;
    }

    public String getStringValue(String key){
        Preferences.Key<String> keyId = PreferencesKeys.stringKey(key);
        Flowable<String> flow = mDataStore.data().map(prefs ->prefs.get(keyId));
        try{
            return flow.blockingFirst();
        }catch(Exception e){
            return "";
        }
    }

    public void setStringValue(String key, String value){
        Preferences.Key<String> keyId = PreferencesKeys.stringKey(key);
        Single<Preferences> result = mDataStore.updateDataAsync(prefs ->{
            MutablePreferences mutablePrefs = prefs.toMutablePreferences();
            mutablePrefs.set(keyId, value);
            return Single.just(mutablePrefs);
        });
    }

    // 设置指定名称的整型数
    public void setIntValue(String key, Integer value) {
        Preferences.Key<Integer> keyId = PreferencesKeys.intKey(key);
        Single<Preferences> result = mDataStore.updateDataAsync(prefs -> {
            MutablePreferences mutablePrefs = prefs.toMutablePreferences();
            //Integer oldValue = prefs.get(keyId);
            mutablePrefs.set(keyId, value);
            return Single.just(mutablePrefs);
        });
    }
    public Integer getIntValue(String key){
        Preferences.Key<Integer> keyId = PreferencesKeys.intKey(key);
        Flowable<Integer> flow = mDataStore.data().map(prefs -> prefs.get(keyId));
        try{
            return  flow.blockingFirst();
        }catch (Exception e){
            return 0;
        }
    }

    // 获取指定名称的双精度数
    public Double getDoubleValue(String key) {
        Preferences.Key<Double> keyId = PreferencesKeys.doubleKey(key);
        Flowable<Double> flow = mDataStore.data().map(prefs -> prefs.get(keyId));
        try {
            return flow.blockingFirst();
        } catch (Exception e) {
            return 0.0;
        }
    }

    // 设置指定名称的双精度数
    public void setDoubleValue(String key, Double value) {
        Preferences.Key<Double> keyId = PreferencesKeys.doubleKey(key);
        Single<Preferences> result = mDataStore.updateDataAsync(prefs -> {
            MutablePreferences mutablePrefs = prefs.toMutablePreferences();
            //Double oldValue = prefs.get(keyId);
            mutablePrefs.set(keyId, value);
            return Single.just(mutablePrefs);
        });
    }

    // 获取指定名称的布尔值
    public Boolean getBooleanValue(String key) {
        Preferences.Key<Boolean> keyId = PreferencesKeys.booleanKey(key);
        Flowable<Boolean> flow = mDataStore.data().map(prefs -> prefs.get(keyId));
        try {
            return flow.blockingFirst();
        } catch (Exception e) {
            return false;
        }
    }

    // 设置指定名称的布尔值
    public void setBooleanValue(String key, Boolean value) {
        Preferences.Key<Boolean> keyId = PreferencesKeys.booleanKey(key);
        Single<Preferences> result = mDataStore.updateDataAsync(prefs -> {
            MutablePreferences mutablePrefs = prefs.toMutablePreferences();
            //Boolean oldValue = prefs.get(keyId);
            mutablePrefs.set(keyId, value);
            return Single.just(mutablePrefs);
        });
    }


}