package com.heyx.tool.color.common.system;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.heyx.tool.color.common.constant.HttpConst;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * 请求返回对象
 *
 * @author: pzy
 * @create: 2020-02-27 15:41
 */
@Data
@Builder
public class ResponseUtils {

    @ApiModelProperty("状态码")
    private Integer status;
    @ApiModelProperty("数据")
    private Object data;
    @ApiModelProperty("消息提醒")
    private String msg;
    @ApiModelProperty("数量")
    private long total;

    public static ResponseUtils getSuccessResponseJo() {
        return ResponseUtils.builder()
                .status(HttpConst.SUCCESS)
                .build();
    }

    public static ResponseUtils getSuccessResponseJoMsg(String msg) {
        return ResponseUtils.builder()
                .msg(msg)
                .status(HttpConst.SUCCESS)
                .build();
    }

    public static ResponseUtils getSuccessResponseJoData(Object data) {
        if (data instanceof IPage){
            return getSuccessResponseJoDataAndTotal(((IPage) data).getRecords(), ((IPage) data).getTotal());
        }
//        else if(data instanceof Page) {
//            return getSuccessResponseJoDataAndTotal(((Page) data).getContent(), ((Page) data).getTotalElements());
//        }

        return ResponseUtils.builder()
                .data(data)
                .status(HttpConst.SUCCESS)
                .build();
    }

    public static ResponseUtils getSuccessResponseJoDataAndTotal(Object data, long total) {
        return ResponseUtils.builder()
                .data(data)
                .total(total)
                .status(HttpConst.SUCCESS)
                .build();
    }

    public static ResponseUtils getFailureResponseJoMsg(String msg, Integer status) {
        return ResponseUtils.builder()
                .msg(msg)
                .status(status)
                .build();
    }

    public static ResponseUtils getIntervalServerResponseJo() {
        return ResponseUtils.builder()
                .msg(HttpConst.ERROR_500)
                .status(HttpConst.INTERNAL_SERVER_ERROR)
                .build();
    }
    public static ResponseUtils getIntervalServerResponseJoMsg(String msg) {
        return ResponseUtils.builder()
                .msg(msg)
                .status(HttpConst.INTERNAL_SERVER_ERROR)
                .build();
    }



    private static void setHeader(HttpServletResponse response, String fileName){
        response.setHeader("Content-disposition", "attachment;filename=\"" + fileName + "\"");
        response.setContentType("application/octet-stream;charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
    }

    public static void response(HttpServletRequest request, HttpServletResponse response, File file, String fileName) {
        OutputStream os = null;
        try {
            response.reset();
            os = response.getOutputStream();
            String headerFileName = "";
            if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                headerFileName = URLEncoder.encode(fileName, "utf-8");
            } else {
                headerFileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
            }
            setHeader(response, headerFileName);
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = new byte[2048];
            int length = 0;
            while ((length = inputStream.read(bytes)) > 0) {
                os.write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 响应文件流
     */
    public static void response(HttpServletRequest request, HttpServletResponse response, InputStream inputStream, String fileName) {
        OutputStream os = null;
        try {
            response.reset();
            os = response.getOutputStream();
            String headerFileName = "";
            if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                headerFileName = URLEncoder.encode(fileName, "utf-8");
            } else {
                headerFileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
            }
            setHeader(response , headerFileName);
            byte[] bytes = new byte[2048];
            int length = 0;
            while ((length = inputStream.read(bytes)) > 0) {
                os.write(bytes, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void responseQrCode(HttpServletRequest request, HttpServletResponse response, String filePath, String fileName) {
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            String headerFileName = "";
            if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0) {
                headerFileName = URLEncoder.encode(fileName, "utf-8");
            } else {
                headerFileName = new String(fileName.getBytes("utf-8"), "ISO8859-1");
            }
            setHeader(response, headerFileName);
            File file = new File(filePath);
            if(!file.exists()){
                file.mkdirs();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
