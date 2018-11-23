package com.lill.study.srv;

import com.lill.study.dao.TestDao;
import com.lill.study.domain.po.TestPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/21 18:28
 * @description spring data api
 */
@Service
public class TestSrv {
    @Autowired
    private TestDao testDao;

    public List<TestPo> findAll() {

        return testDao.findAll();
//        return null;
    }
}
