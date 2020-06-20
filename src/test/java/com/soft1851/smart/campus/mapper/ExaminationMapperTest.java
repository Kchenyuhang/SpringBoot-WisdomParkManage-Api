package com.soft1851.smart.campus.mapper;

import com.soft1851.smart.campus.model.entity.Examination;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@SpringBootTest
class ExaminationMapperTest {

    @Resource
    private ExaminationMapper examinationMapper;

    @Test
    void selectExaminationByClazzIdAndSubject() {
        List<Examination> examinationList = examinationMapper.selectExaminationByClazzIdAndSubject1((long) 2, (long) 2, "2012-2013学年第一学期");
        System.out.println(examinationList.size());
    }

    @Test
    void selectExaminationByTime() {
        // 根据班级id和学期id查询出该班级本学期所有的课程
        List<Examination> examinationList = examinationMapper.getExaminationBySemesterAndClazzId("2012-2013学年第一学期", (long) 2);
        // 过滤重复的 保留每个学科的一条数据
        Set<Examination> examinations = new TreeSet<>((o1, o2) -> o1.getSubjectId().compareTo(o2.getSubjectId()));
        examinations.addAll(examinationList);
        // 存储过滤后的数据
        List<Examination> examinationList1 = new ArrayList<Examination>(examinations);
//        System.out.println(examinationList1);
//        Boolean isInsert1 = DateUtil.getTimeCompare("2020-06-28 05:20:20","2020-06-28 06:20:20",examinationList1);
//        System.out.println(isInsert1);
//        Boolean isInsert2 = DateUtil.getTimeCompare("2020-06-28 00:20:20","2020-06-28 00:40:20",examinationList1);
//        System.out.println(isInsert2);
//        Boolean isInsert3 = DateUtil.getTimeCompare("2020-06-28 04:20:20","2020-06-28 05:40:20",examinationList1);
//        System.out.println(isInsert3);

    }

    @Test
    void timeTest() {
        Timestamp a = Timestamp.valueOf("2020-06-04 05:56:20");
        Timestamp b = Timestamp.valueOf("2020-06-04 05:56:20");
        if (b.before(a)){
            System.out.println("b时间比a早");
        }else if (b.after(a)){
            System.out.println("b时间比a迟");
        }else {
            System.out.println("时间相同");
        }

    }
}