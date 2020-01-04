package com.dimanche.mybase.app;

import java.io.File;

/**
 * @author Dimanche
 * @description:
 * @date : 2020/1/4 0:36
 */
public class Constants {

    //==============PATH===============
    //当存储不足时，该目录下的文件会被系统删除，一般用作应用的缓存使用
    public static final String PATH_DATA = App.getInstance().getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/NetCache";


}
