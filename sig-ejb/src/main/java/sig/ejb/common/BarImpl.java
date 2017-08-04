package sig.ejb.common;



import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.example.Blog;
import org.mybatis.example.BlogMapper;

import sig.ejb.common.Bar;
import sig.mybatis.MyBatisUtil;

@Stateless
public class BarImpl implements Bar {

	@Override
	public String Saludar() {
		SqlSession session = new MyBatisUtil().getSession();

        if (session != null) {
        	try {
                BlogMapper mapper = session.getMapper(BlogMapper.class);
                Blog blog = mapper.selectBlog(1);
                System.out.println(blog);
              } finally {
                session.close();
              }

        } else {
            System.out.println("ERROR");
        }

		return "mensaje desde ejb con";
	}

}
