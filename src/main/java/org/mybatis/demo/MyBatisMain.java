package org.mybatis.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.BlogMapper;

import java.io.IOException;
import java.io.InputStream;

/**
 * 手动添加 Mapper 的情况下
 * 1、mybatis-config.xml 里不需要注入 BlogMapper / mybatis-config.xml
 * 2、BlogMapper 也不需要加 @Mapper 注解
 */
public class MyBatisMain {

  public static void main(String[] args) throws IOException {
    // 全局配置
    String resource = "mybatis-config.xml";

//    String resource = "G:\\myGitHubProject\\mybatis-3\\src\\test\\java\\resources\\mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory =
      new SqlSessionFactoryBuilder().build(inputStream);

    // 如何操作数据库
    // SqlSession 并没有访问数据库，只是创建了一个执行器
    SqlSession session = sqlSessionFactory.openSession();

    // xml 的方式
    session.getConfiguration().addMapper(BlogMapper.class);
    BlogMapper mapper = session.getMapper(BlogMapper.class);
    System.out.println(mapper.selectBlog(101));
    System.out.println(mapper.selectBlog(101));
    //selectOne 是真正访问数据库的
//    Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog",101);
    // 验证缓存的使用
//    Blog blog3 = session.selectOne("org.mybatis.example.BlogMapper.selectBlog",101);
//    // 注解的方式
//    BlogMapper mapper = session.getMapper(BlogMapper.class);
//    Blog blog2 = mapper.selectOneBlog(101);

//    System.out.println(blog);
//    System.out.println(blog2);
//    System.out.println(blog3);

  }
}
