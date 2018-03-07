package com.example.administrator.xiaodemo2.clazz;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Administrator on 2018/3/6.
 */

@Entity
public class Shou {

    @Id
    private Long id;
    @Property(nameInDb = "name")
    private String name;
    @Property(nameInDb = "content")
    private String content;
    @Property(nameInDb = "img")
    private String img;
    @Generated(hash = 310666312)
    public Shou(Long id, String name, String content, String img) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.img = img;
    }
    @Generated(hash = 1806687297)
    public Shou() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }

}
