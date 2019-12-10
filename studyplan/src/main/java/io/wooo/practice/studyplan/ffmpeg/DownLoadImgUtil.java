package io.wooo.practice.studyplan.ffmpeg;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class DownLoadImgUtil {

    public static void main(String[] args) {
        readCsvAndDownLoadImage("C:\\Users\\wb-wsp312690\\Desktop\\sqlresult_4483836.csv");
    }

    public static void readCsvAndDownLoadImage(String filePath){
        List<ImageModel> images = readCsv(filePath);
        AtomicInteger i = new AtomicInteger(1);
        images.forEach(imageModel -> {
            String fileName = i.getAndIncrement() + ".jpg";
            download(imageModel, fileName, "D:\\sc2\\");
        });
    }

    public static List<ImageModel> readCsv(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            ArrayList<ImageModel> list = new ArrayList<>();
            reader.lines()
                    .filter(line -> !line.contains("left_top"))
                    .forEach(line -> {
                        line = line.replaceAll("︴", "','");
                        line = line.replaceAll("\"", "");
                        String[] dataArr = line.split(",");
                        String imgUrl = "http://47.106.194.99:30761/storage/getPicture/" + dataArr[6];
                        ImageModel imageModel = new ImageModel();
                        imageModel.setLeftTopX(Integer.parseInt(dataArr[0]));
                        imageModel.setLeftTopY(Integer.parseInt(dataArr[1]));
                        imageModel.setRightBtmX(Integer.parseInt(dataArr[2]));
                        imageModel.setRightBtmY(Integer.parseInt(dataArr[3]));
                        imageModel.setImgUrl(imgUrl);
                        list.add(imageModel);
                    });
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void download(ImageModel imageModel, String fileName, String savePath){
        try {
            // 构造URL
            URL url = new URL(imageModel.getImgUrl());
            // 打开连接
            URLConnection con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5 * 1000);
            // 输入流
            InputStream is = con.getInputStream();

            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf = new File(savePath);
            if (!sf.exists()) {
                sf.mkdirs();
            }
            String filePath = sf.getPath() + System.getProperty("file.separator");
            OutputStream os = new FileOutputStream(filePath + fileName);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 给每个图片指定位置添加红框
            ImageUtils.addBorderToImage(imageModel, filePath, fileName);
            // 完毕，关闭所有链接
            os.close();
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
