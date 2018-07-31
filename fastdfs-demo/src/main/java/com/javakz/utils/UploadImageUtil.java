package com.javakz.utils;

import org.csource.fastdfs.*;

/**
 *  .--,       .--,
 * ( (  \.---./  ) )
 *  '.__/o   o\__.'
 *     {=  ^  =}
 *      >  -  <
 *     /       \
 *    //       /
 *   //|   .   |/
 *   "'\       /'"_.-~^`'-.
 *      \  _  /--'         `
 *    ___)( )(___
 *   (((__) (__)))    高山仰止,景行行止.虽不能至,心向往之。
 * ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
 * @Author: yandq
 * @Description: 图片上传
 * @Date: Create in 18:02 2018/7/30
 * @Modified By: 
 */
public class UploadImageUtil {

    public static void main(String[] args) throws Exception {
        // 加载配置文件，配置文件中的内容就是 tracker 服务的地址。
        ClientGlobal.init("D:/Work/Workspaces/IdeaProjects/Git/high-end-technology/fastdfs-demo/src/main/resources/context/fdfs-client.conf");
        // 创建一个 TrackerClient 对象。直接 new 一个。
        TrackerClient trackerClient = new TrackerClient();
        // 使用 TrackerClient 对象创建连接，获得一个 TrackerServer 对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 创建一个 StorageServer 的引用，值为 null
        StorageServer storageServer = null;
        // 创建一个 StorageClient 对象，需要两个参数 TrackerServer 对象、StorageServer 的引用
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 使用 StorageClient 对象上传图片。扩展名不带“.”
        String[] strs = storageClient.upload_file("D:/20180420101144.png","png", null);
        // 返回数组。包含组名和图片的路径。
        for (String str : strs) {
            System.out.println(str);
        }
    }

}
