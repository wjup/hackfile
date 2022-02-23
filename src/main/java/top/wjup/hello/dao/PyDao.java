package top.wjup.hello.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class PyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map<String, Object> getConfig() {

        String sql = "select file_type as type,file_path as path,file_name as name from file_hack_config where state = 1";

        return jdbcTemplate.queryForMap(sql);
    }
}
