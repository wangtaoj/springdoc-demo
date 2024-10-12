package com.wangtao.springdoc.pojo.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author wangtao
 * Created at 2023-09-10
 */
@Data
@Schema(name = "文件", description = "文件对象")
public class FileRespVO {

    @Schema(description = "随机名称")
    private String random;
    @Schema(description = "文件名称")
    private String name;
    @Schema(description = "文件大小")
    private Long size;
    @Schema(description = "是否上传成功")
    private Boolean success;
}
