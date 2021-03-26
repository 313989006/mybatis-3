package org.mybatis.demo;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName Blog
 * @Description TODO
 * @Author ma.kangkang
 * @Date 2021/2/2 16:42
 **/
@Alias("blog")
public class Blog {

  private Integer id;

  private String name;

  private String content;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Blog{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", content='" + content + '\'' +
      '}';
  }
}
