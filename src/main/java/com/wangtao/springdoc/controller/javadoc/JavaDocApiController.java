package com.wangtao.springdoc.controller.javadoc;

import com.wangtao.springdoc.pojo.Result;
import com.wangtao.springdoc.pojo.vo.JavaDocVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JavaDoc API示例接口
 * @author wangtao
 * Created at 2023-09-17
 */
@RequestMapping("/api/doc")
@RestController
public class JavaDocApiController {

    /**
     * 新增(返回值带泛型)
     * @param javaDoc 实体
     * @return 返回实体
     */
    @PostMapping("/add")
    public Result<JavaDocVO> add(@RequestBody JavaDocVO javaDoc) {
        return Result.success(javaDoc);
    }

    /**
     * 简单参数
     * @param name 名字
     * @return 名字
     */
    @PostMapping("/simple")
    public String simple(String name) {
        return name;
    }
}
