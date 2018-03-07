package com.example.administrator.xiaodemo2.clazz;

import java.util.List;

/**
 * Created by Administrator on 2018/3/6.
 */

public class Mybean {

    /**
     * Students : {"Student":[{"name":"张三","content":"学生简介学生简介学生简介学生简介学生简介","img":"http:ds/201508/05/1438760755_6715.jpeg"},{"name":"Alss","content":"学习好，是一个三好学生，班花","img":"http://img.my.csdn.net/uploads/201508/05/1438760726_5120.jpg"},{"name":"哇哈哈","content":"学习好，是一个三好学生","img":"http://img.my.csdn.net/uploads/201508/05/1438760726_8364.jpg"},{"name":"hander","content":"学习好，是一个三好学生","img":"http://img.my.csdn.net/uploads/201508/05/1438760725_4031.jpg"},{"name":"EventBus","content":"学习好，是一个三好学生","img":"http://img.my.csdn.net/uploads/201508/05/1438760724_9463.jpg"},{"name":"Android","content":"喜欢英语，擅长代码","img":"http://img.my.csdn.net/uploads/201508/05/1438760724_2371.jpg"}]}
     */

    private StudentsBean Students;

    public StudentsBean getStudents() {
        return Students;
    }

    public void setStudents(StudentsBean Students) {
        this.Students = Students;
    }

    public static class StudentsBean {
        private List<StudentBean> Student;

        public List<StudentBean> getStudent() {
            return Student;
        }

        public void setStudent(List<StudentBean> Student) {
            this.Student = Student;
        }

        public static class StudentBean {
            /**
             * name : 张三
             * content : 学生简介学生简介学生简介学生简介学生简介
             * img : http:ds/201508/05/1438760755_6715.jpeg
             */

            private String name;
            private String content;
            private String img;

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

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}
