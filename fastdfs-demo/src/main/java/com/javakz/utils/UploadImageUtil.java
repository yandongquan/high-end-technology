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
 * @Description: 
 * @Date: Create in 18:02 2018/7/30
 * @Modified By: 
 */
public class UploadImageUtil {

    public static void main(String[] args) throws Exception {
        ClientGlobal.init("D:/Work/Workspaces/IdeaProjects/Git/high-end-technology/fastdfs-demo/src/main/resources/context");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        String[] strs = storageClient.upload_file("D:/20180420101144.png","png", null);
        for (String str : strs) {
            System.out.println(str);
        }
    }

}
