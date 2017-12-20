package com.example.demo.Utils;
import org.python.antlr.ast.Str;
import org.springframework.util.ClassUtils;

import java.io.File;

public class Constant {
    public static final Integer mid=4;
    public static final Integer small=2;
    public static final Integer six=6;
    public static final Integer big=8;
    //项目绝对路径,用于上传文件的时候保存
    public static final String projectAbsolutePath=
            ClassUtils.getDefaultClassLoader().getResource("").getPath();
    //上传的动态文件路径,在url中可以直接访问,根据不同的模块,表名字存放在不同的文件夹
    //协议+主机+端口+项目名   对应目标文件中的static
    //也就是说  http:localhost:8888/jsu/resource 在内部是  /jsu/resource
    public static final String dynamicResoruce=projectAbsolutePath+
            File.separator +"static" + File.separator + "resource" + File.separator;
    public static String RESOURCE="resource"+File.separator;
}
