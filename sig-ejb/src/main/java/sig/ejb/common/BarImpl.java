package sig.ejb.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.example.Blog;
import org.mybatis.example.BlogMapper;

import sig.ejb.common.Bar;
import sig.mybatis.MyBatisUtil;

import com.sig.camunda.bpm_lib.*;

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

	@Override
	public Map<String, Object> iniciarProceso(String proceso) {

		CamundaEngine camunda = new CamundaEngine();
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("idProceso", camunda.processCreate(proceso, "", "", ""));

		return variables;
	}
	@Override
	public List<String> listaInstancias(String proceso) {
		CamundaEngine camunda = new CamundaEngine();
		return camunda.getProcessInstances(proceso);
	}

}
