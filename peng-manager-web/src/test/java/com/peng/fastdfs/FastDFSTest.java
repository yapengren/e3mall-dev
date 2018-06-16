package com.peng.fastdfs;

import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * 分布式文件系统测试类
 *
 * @author renyapeng
 * @date 2018/06/16
 */
public class FastDFSTest {

    @Test
    public void testUpload() throws Exception {
        // 创建一个配置文件，client.conf，内容就是tracker服务器的ip及端口号
        // 加载配置文件
        ClientGlobal.init("D:\\Develop\\peng\\peng-manager-web\\src\\main\\resources\\conf\\client.conf");
        // 创建一个 TrackerClient 对象
        TrackerClient trackerClient = new TrackerClient();
        // 使用 TrackerClient 对象获得 TrackerServer 对象
        TrackerServer trackerServer = trackerClient.getConnection();
        // 创建一个 StorageClient 对象，需要两个构造参数，一个 TrackerServer，StorageServer 可以是null
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 使用 StorageClient 对象上传文件，服务端返回一个路径及文件名
        // 参数1：本地文件的路径及文件名
        // 参数2：文件的扩展名，不带"."
        // 参数3：元数据，图片的信息。可以为null
        String[] strings = storageClient.upload_file("C:\\Users\\renyapeng\\Pictures\\daidai.jpg", "jpg", null);
        for (String s: strings) {
            System.out.println(s);
        }
    }
}
