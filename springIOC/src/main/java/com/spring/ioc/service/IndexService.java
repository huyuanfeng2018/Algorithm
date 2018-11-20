package com.spring.ioc.service;

import com.spring.ioc.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * IndexService
 * <p>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2018/9/26</BR>
 *
 * @author ��Դ��
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
