package sig.ejb.common;



import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.example.Blog;
import org.mybatis.example.BlogMapper;

import com.sig.camunda.bpm_lib.CamundaEngineLib;

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

        
    	Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("var", "2");
		CamundaEngineLib a = new CamundaEngineLib();
		String as = a.processCreate("Process_1", "", "", "", variables);
		
        
		return "mensaje desde ejb con";
	}

}
