package me.guopop.springbooteasyexcel;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guopop
 * @date 2021/7/30 8:56
 */
@Slf4j
public class UserListener extends AnalysisEventListener<User> {
    private static final int BATCH_COUNT = 1000;

    List<User> list = new ArrayList<>();

    @Override
    public void invoke(User user, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSONUtil.toJsonStr(user));
        list.add(user);
        if (list.size() >= BATCH_COUNT) {
            log.info("count:{}", list.size());
            list.clear();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("sum: {}", list.size());
    }
}
