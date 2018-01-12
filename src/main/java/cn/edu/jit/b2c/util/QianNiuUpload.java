package cn.edu.jit.b2c.util;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

import java.io.IOException;

/**
 * Created by ChenQF on 2018/1/11.
 */
public class QianNiuUpload {
    //设置好账号的ACCESS_KEY和SECRET_KEY
    public static String ACCESS_KEY = "UwDMLe-DcZ6owIanBcwK77fWHJzkI-G025iHzkYc";
    public static String SECRET_KEY = "ySVZoNvAQos9bDivIxjJC3OjckrYq5mnVFdA9zR4";
    //要上传的空间
    public static String bucketname = "image";
    //上传到七牛后保存的文件名
    public static String key = "my-java.png";
    //上传文件的路径
    public static String FilePath = "F:\\img\\1483600033410.jpeg";

    //密钥配置
    public static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    ///////////////////////指定上传的Zone的信息//////////////////
    //第一种方式: 指定具体的要上传的zone
    //注：该具体指定的方式和以下自动识别的方式选择其一即可
    //要上传的空间(bucket)的存储区域为华东时
    // Zone z = Zone.zone0();
    //要上传的空间(bucket)的存储区域为华北时
    // Zone z = Zone.zone1();
    //要上传的空间(bucket)的存储区域为华南时
    // Zone z = Zone.zone2();

    //第二种方式: 自动识别要上传的空间(bucket)的存储区域是华东、华北、华南。
    public static Zone z = Zone.autoZone();
    public static Configuration c = new Configuration(z);

    //创建上传对象
    private static UploadManager uploadManager = new UploadManager(c);

    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    public static String getUpToken() {
        return auth.uploadToken(bucketname);
    }

    public static void upload() throws IOException {
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }
}
