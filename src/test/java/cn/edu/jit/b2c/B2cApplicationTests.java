package cn.edu.jit.b2c;

import cn.edu.jit.b2c.mapper.UserMapper;
import cn.edu.jit.b2c.mapper.UserShopMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class B2cApplicationTests {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserShopMapper userShopMapper;
	@Test
	public void contextLoads() {
	}

}
