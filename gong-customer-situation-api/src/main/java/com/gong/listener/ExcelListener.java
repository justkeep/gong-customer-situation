package com.gong.listener;

import com.alibaba.excel.read.context.AnalysisContext;
import com.alibaba.excel.read.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/1/9/009.
 */
public class ExcelListener extends AnalysisEventListener {
    private List<Object> datas = new ArrayList<Object>();

    @Override
    public void invoke(Object o, AnalysisContext analysisContext) {
        System.out.println("当前行："+analysisContext.getCurrentRowNum());
        System.out.println(o);
        datas.add(o);//数据存储到list，供批量处理，或后续自己业务逻辑处理。
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }


    public List<Object> getDatas() {
        return datas;
    }
    public void setDatas(List<Object> datas) {
        this.datas = datas;
    }

}
