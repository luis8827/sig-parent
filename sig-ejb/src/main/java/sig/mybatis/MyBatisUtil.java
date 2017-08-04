package sig.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private String resource = "org/mybatis/example/mybatis-config.xml";
    private SqlSession session = null;

    public SqlSession getSession() {
        try {
//            Reader reader = Resources.getResourceAsStream(resource);
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlMapper= new SqlSessionFactoryBuilder().build(inputStream);
            session =sqlMapper.openSession();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return session;
    }
}
