package de.etc.sb.etc_a3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

@SpringBootTest
public class FindDataSourceTest {

    @Autowired(required = false)
    DataSource dataSource;

    @Test
    void printDatasource() {
        System.out.println("DataSource = " + dataSource);
    }
}
