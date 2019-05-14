package com.breakman.cloud.utils.io;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgZipUtil {
    /**
     * 根据设置的宽高等比例压缩图片文件<br> 先保存原文件，再压缩、上传
     *
     * @param oldFilePath 要进行压缩的文件路径
     * @param newFilePath 新文件路径
     * @param width       宽度 //设置宽度时（高度传入0，等比例缩放）
     * @param height      高度 //设置高度时（宽度传入0，等比例缩放）
     * @param quality     质量
     * @return 返回压缩后的文件的全路径
     */
    public static String zipImageFile(String oldFilePath, String newFilePath, int width, int height, float quality) {
        if (oldFilePath == null) {
            return null;
        }
        File oldFile = new File(oldFilePath);
        File newFile = new File(newFilePath);
        try {
            /* 对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(oldFile);
            int w = srcFile.getWidth(null);
            int h = srcFile.getHeight(null);
            double bili;
            if (width > 0) {
                bili = width / (double) w;
                height = (int) (h * bili);
            } else {
                if (height > 0) {
                    bili = height / (double) h;
                    width = (int) (w * bili);
                }
            }
            String srcImgPath = newFile.getAbsoluteFile().toString();
            String subfix = "jpg";
            subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());
            BufferedImage buffImg;
            if (subfix.equals("png") && subfix.equals("jpg")) {
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            } else {
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            }

            Graphics2D graphics = buffImg.createGraphics();
            graphics.setBackground(new Color(255, 255, 255));
            graphics.setColor(new Color(255, 255, 255));
            graphics.fillRect(0, 0, width, height);
            graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

            ImageIO.write(buffImg, subfix, new File(srcImgPath));

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(newFilePath);
        System.out.println(newFile.getAbsolutePath());
        return newFile.getAbsolutePath();
    }

    /**
     * 按设置的宽度高度压缩图片文件<br> 先保存原文件，再压缩、上传
     *
     * @param oldFile 要进行压缩的文件
     * @param newFile 新文件
     * @param width   宽度
     * @param height  高度
     * @param quality 质量
     * @return 返回压缩后的文件的全路径
     */
    public static String zipWidthHeightImageFile(File oldFile, File newFile, int width, int height, float quality) {
        if (oldFile == null) {
            return null;
        }
        String newImage = null;
        try {
            /* 对服务器上的临时文件进行处理 */
            Image srcFile = ImageIO.read(oldFile);

            String srcImgPath = newFile.getAbsolutePath();
            System.out.println(srcImgPath);
            String subfix;
            subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());

            BufferedImage buffImg;
            if (subfix.equals("png")) {
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            } else {
                buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            }

            Graphics2D graphics = buffImg.createGraphics();
            graphics.setBackground(new Color(255, 255, 255));
            graphics.setColor(new Color(255, 255, 255));
            graphics.fillRect(0, 0, width, height);
            graphics.drawImage(srcFile.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);

            ImageIO.write(buffImg, subfix, new File(srcImgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newImage;
    }

    /*** 
     * 按指定的比例缩放图片 
     * @param sourceImagePath
     *      源地址 
     * @param destinationPath
     *      改变大小后图片的地址 
     * @param scale
     *      缩放比例，如1.2 
     */
    public static void scaleImage(String sourceImagePath,
                                  String destinationPath, double scale, String format) throws IOException {

        File file = new File(sourceImagePath);
        BufferedImage bufferedImage;
        bufferedImage = ImageIO.read(file);
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();

        width = (int) (width * scale);
        height = (int) (height * scale);

        Image image = bufferedImage.getScaledInstance(width, height,
            Image.SCALE_SMOOTH);
        BufferedImage outputImage = new BufferedImage(width, height,
            BufferedImage.TYPE_INT_RGB);
        Graphics graphics = outputImage.getGraphics();
        graphics.drawImage(image, 0, 0, null);
        graphics.dispose();
        ImageIO.write(outputImage, format, new File(destinationPath));
    }

    public static boolean DeleteFolder(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 判断目录或文件是否存在  
        if (!file.exists()) {  // 不存在返回 false  
            return false;
        } else {
            if (file.isFile() && file.exists()) {  // 路径为文件且不为空则进行删除  
                file.delete();
                flag = true;
            }
        }
        return flag;
    }
}
