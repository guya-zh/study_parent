package com.lill.study.dao.read;

import com.lill.study.domain.po.TestPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author 李亮亮
 * @project xtone-framework
 * @company 成都信通信息技术有限公司
 * @date 2018/11/21 18:29
 * @description  spring data api
 */
@Repository("readTestDao")
public interface TestDao extends JpaRepository<TestPo, String> {
//public interface TestDao {

}

