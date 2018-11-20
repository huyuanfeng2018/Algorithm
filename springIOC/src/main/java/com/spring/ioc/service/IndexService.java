package com.spring.ioc.service;

import com.spring.ioc.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * IndexService
 * <p>
 * 技术支持：广东凯通科技股份有限公司 (c) 2018/9/26</BR>
 *
 * @author 胡源锋
 * @version 1.0
 * @since JDK1.7
 */
@Service
public class IndexService {
    @Autowired
    IndexDao indexDao;

    public  void index() {
        indexDao.inde();
    }
}
