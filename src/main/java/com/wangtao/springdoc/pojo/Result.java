package com.wangtao.springdoc.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回对象
 * @author wangtao
 * Created at 2019/10/21 18:53
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Result<T> {

    private static final int SUCCESS_CODE = 1;

    private static final int ERROR_CODE = 0;

    /**
     * 响应码
     */
    private int code;

    /**
     * 错误原因
     */
    private String errMsg;

    /**
     * 响应数据
     */
    private T data;

    private Result(int code) {
        this.code = code;
    }

    private Result(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private Result(int code, String errMsg) {
        this.code = code;
        this.errMsg = errMsg;
    }

    /**
     * 成功响应, 不带数据
     * @param <T> 泛型参数
     * @return 返回一个成功结果
     */
    public static <T> Result<T> success() {
        return new Result<>(SUCCESS_CODE);
    }

    /**
     * 成功响应, 带数据
     * @param data 响应数据
     * @param <T> 泛型参数
     * @return 返回一个成功结果
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS_CODE, data);
    }

    public static <T> Result<T> error() {
        return new Result<>(ERROR_CODE);
    }

    /**
     * 失败响应
     * @param errMsg 错误消息
     * @param <T> 泛型参数
     * @return 返回一个失败结果
     */
    public static <T> Result<T> error(String errMsg) {
        return new Result<>(ERROR_CODE, errMsg);
    }
}
