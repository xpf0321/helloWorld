package com.breakman.cloud.common.model;

/**
 * Created by hzhang on 2017/6/8.
 */
public class UploadView {

    private String fileName;        //文件名
    private String filePath;        //文件路径
    private Long fileSize;          //文件大小
    private String targetFileName;  //临时文件名
    private String contentType;     //内容类型

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public String getTargetFileName() {
        return targetFileName;
    }

    public void setTargetFileName(String targetFileName) {
        this.targetFileName = targetFileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
