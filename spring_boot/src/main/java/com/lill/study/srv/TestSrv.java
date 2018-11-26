package com.lill.study.srv;

import com.lill.study.dao.write.TestDao;
import com.lill.study.domain.po.TestPo;
import com.lill.study.target.ReadDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("writeTestDao")
    private TestDao writeTestDao;

    @Autowired
    @Qualifier("readTestDao")
    private com.lill.study.dao.read.TestDao readTestDao;

    public List<TestPo> findAll() {

        return writeTestDao.findAll();
//        return null;
    }
    @ReadDataSource
    public List<TestPo> wfind() {

        return writeTestDao.findAll();
//        return null;
    }

    public List<TestPo> find() {

        return readTestDao.findAll();
//        return null;
    }
}
