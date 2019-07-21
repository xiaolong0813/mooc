package day03.transactionAnno;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    // 需要得到jdbcTemplate对象，在配置中注入,设置set方法
    private JdbcTemplate jdbcTemplate;

    // 实现转账，小王少钱，小马多钱
    // account是建立的包含小王和小马的钱的表
    public void lessMoney() {
        String sql = "update account set salary=salary-? where username=?";
        jdbcTemplate.update(sql, 1000, "小王");
    }
    public void moreMoney() {
        String sql = "update account set salary=salary-? where username=?";
        jdbcTemplate.update(sql, -1000, "小马");
    }
}
