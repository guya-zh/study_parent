package com.lill.study.dao.write;

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
@Repository("writeTestDao")
public interface TestDao extends JpaRepository<TestPo, String> {
//public interface TestDao {

}
