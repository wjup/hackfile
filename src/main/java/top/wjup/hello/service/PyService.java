package top.wjup.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wjup.hello.dao.PyDao;

import java.util.Map;

@Service
public class PyService {

    @Autowired
    private PyDao pyDao;

    public Map<String, Object> getConfig() {
        return pyDao.getConfig();
    }
}
