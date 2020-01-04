package com.dimanche.mybase.di.module;

import com.dimanche.mybase.BuildConfig;
import com.dimanche.mybase.app.Constants;
import com.dimanche.mybase.utils.SystemUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 0:00
 */
@Module
public class HttpModule {

    @Singleton
    @Provides
    Retrofit.Builder providerRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient.Builder providerOkHttpBuilder() {
        return new OkHttpClient.Builder();
    }

    @Singleton
    @Provides
    OkHttpClient providerOkHttpClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            //消息拦截器，用于记录应用中网络请求的信息
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        //设置缓存路径及最大值
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        //拦截器，对http请求和响应进行统一处理，可以用来实现网络监听、请求以及响应重写、请求失败充实等
        //可以设置任意数量的Intercepter来对网络请求以及其响应做任何中间处理，例如设置缓存、HTTPS证书认证，
        //统一对请求加密/防篡改、打印log、过滤请求等
        Interceptor cacheInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //如果网络不可用，则优先使用本地缓存
                if (!SystemUtils.isNetworkConnected()) {
                    request = request.newBuilder()
                            .cacheControl(CacheControl.FORCE_CACHE)//仅仅使用缓存
                            .build();
                }
                Response response = chain.proceed(request);
                if (SystemUtils.isNetworkConnected()) {
                    int maxAge = 0;
                    //有网络时不缓存，最大保存时长为0
                    response.newBuilder().header("Cache-Control", "public, max-age=" + maxAge)
                            .removeHeader("Pragma")
                            .build();
                } else {
                    //没有网络时，设置超时时间为4周
                    int maxStale = 60 * 60 * 24 * 7 * 4;
                    response.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .removeHeader("Pragma")
                            .build();
                }
                return response;
            }
        };
        //设置缓存
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);

        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);

        //错误重连
        builder.retryOnConnectionFailure(false);
        return builder.build();
    }

    /**
     * 创建Retrofit
     *
     * @param builder
     * @param okHttpClient
     * @param url
     * @return
     */
    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient okHttpClient, String url) {
        return builder.baseUrl(url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

}
