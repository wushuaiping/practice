package io.wooo.practice.studyplan.ffmpeg;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author wb-wsp312690
 */
public class ImageUtils {

    public static void addBorderToImage(ImageModel imageModel, String path, String fileName) {

        String fileRealPath = path + fileName;

        try {
            // 构造Image对象
            Image src = ImageIO.read(new File(fileRealPath));
            // 得到源图宽
            int width = src.getWidth(null);
            // 得到源图长
            int height = src.getHeight(null);

            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics graphics = image.getGraphics();
            // 绘制图
            graphics.drawImage(src, 0, 0, width, height, null);
            // 画边框
            graphics.setColor(Color.RED);
            int leftTopX = imageModel.getLeftTopX();
            int leftTopY = imageModel.getLeftTopY();
            int rightBtmX = imageModel.getRightBtmX();
            int rightBtmY = imageModel.getRightBtmY();
            int iWidth = rightBtmX - leftTopX;
            int iHeight = rightBtmY - leftTopY;
            graphics.drawRect(leftTopX, leftTopY, iWidth, iHeight);
            graphics.drawRect(leftTopX + 1, leftTopY + 1, iWidth + 1, iHeight + 1);

            // 输出到文件流
            String formatName = fileRealPath.substring(fileRealPath.lastIndexOf(".") + 1);
            ImageIO.write(image, formatName, new File("D:\\scto\\" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
