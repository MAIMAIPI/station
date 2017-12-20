package com.example.demo.Utils;


import org.codehaus.groovy.runtime.StringGroovyMethods;

import java.io.File;

public class DirDeal {
    public static String createModelDir(String modelName){//根据模块创建文件夹,存储该模块的所有文件
        String modelDir= Constant.dynamicResoruce+modelName;
        File file=new File(modelDir);
        if(!file.exists()){
            file.mkdir();
            //System.out.print("创建");
        }
        //System.out.print(file.exists()+"   "+file.getPath());
        return file.getPath();
    }
    public static void main(String[] args){
        createModelDir("pr2owq/we");
    }
}
