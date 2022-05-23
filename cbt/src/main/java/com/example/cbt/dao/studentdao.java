package com.example.cbt.dao;

import com.example.cbt.pojo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class studentdao {
    public static Map<Integer, student>stu;
    @Autowired
    gradedao gra;
    static {
        stu=new HashMap<Integer,student>();
        stu.put(1,new student(216101,001,"池邦托","语文",100,"老师1","物联2161",1));
    }
    //查询
    public Collection<student>getall(){
        return stu.values();
    }
    //增加
    private static Integer ID=2;
    public void add(student st){
        if (st.getTimer()==null){
            st.setTimer(ID++);
        }
//        if (st.getGrade()==null){
//            st.setGrade(gra.getgrade(st.getName()));
//        }
        stu.put(st.getTimer(),st);
    }
    public Integer getID(String name){
        Integer a=stu.get(name).getID();
        return a;
    }
    public void delete(Integer ID){
        stu.remove(ID);
    }
    public student getby(Integer ID){
        return stu.get(ID);
    }
}
