package com.gong.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * Created by Administrator on 2019/1/9/009.
 */
@Data
public class User extends BaseRowModel {
    @ExcelProperty(value = "姓名")
    private String name;

    @ExcelProperty(value = "年龄")
    private String age;

    @ExcelProperty(value = "性别")
    private String sex;
}
