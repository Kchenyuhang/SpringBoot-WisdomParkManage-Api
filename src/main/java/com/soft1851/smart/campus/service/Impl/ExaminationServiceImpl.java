package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.mapper.ExaminationMapper;
import com.soft1851.smart.campus.mapper.UserAccountMapper;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.model.vo.EntityVo;
import com.soft1851.smart.campus.model.vo.ExaminationVo;
import com.soft1851.smart.campus.repository.ExaminationRepository;
import com.soft1851.smart.campus.service.ExaminationService;
import com.soft1851.smart.campus.utils.DataTypeChange;
import com.soft1851.smart.campus.utils.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xunmi
 * @ClassName ExaminationServiceImpl
 * @Description TODO
 * @Date 2020/5/31
 * @Version 1.0
 **/
@Service
public class ExaminationServiceImpl implements ExaminationService {

    @Resource
    private ExaminationRepository examinationRepository;
    @Resource
    private UserAccountMapper userAccountMapper;
    @Resource
    private ExaminationMapper examinationMapper;


    @Override
    public ResponseResult updateInfo(Examination examination) {
        return null;
    }

    /**
     * 新增考务
     *
     * @param examination
     * @return
     */
    @Override
    public ResponseResult increaseInfo(Examination examination) {
        // 组成考务list
        List<Examination> examinationList = new ArrayList<>();
        // 通过班级id查询所属班级的学生id
        List<String> studentIds = null;
        try {
            studentIds = userAccountMapper.findJobNumberByClazzId(examination.getClazzId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //****************判断此班级是否已经考过此科目*******************************
        List<Examination> numberExamination1 = examinationMapper.selectExaminationByClazzIdAndSubject(examination.getClazzId(), examination.getSubjectId(), examination.getSemester());
        List<Examination> numberExamination2 = examinationMapper.selectExaminationByClazzIdAndSubject1(examination.getClazzId(), examination.getSubjectId(), examination.getSemester());


        //****************判断该班级同时间是否还有其他考试****************************
        //判断该班级同时间段是否存在其他的考试 时间冲突问题
        //1.首先根据班级id和学期id查询出该班级本学期的所有课程
        List<Examination> examinationAllList = examinationMapper.getExaminationBySemesterAndClazzId(examination.getSemester(), examination.getClazzId());
        // 过滤重复的 保留每个学科的一条数据
        Set<Examination> examinations = new TreeSet<>((o1, o2) -> o1.getSubjectId().compareTo(o2.getSubjectId()));
        examinations.addAll(examinationAllList);
        // 存储过滤后的数据
        List<Examination> examinationAllList1 = new ArrayList<Examination>(examinations);
        Boolean isClazzInsert = DateUtil.getTimeCompare(examination.getStartTime(), examination.getFinishTime(), examinationAllList1);


        //****************判断同时间该教师是否有其他监考场次****************************
        List<Examination> examinationTeacherList = examinationMapper.getExaminationsByTeacherId(examination.getTeacherId(), examination.getSemester());
        //多条件过滤   将收集的结果转换为另一种类型: collectingAndThen  根据班级id和学科id
        List<Examination> examinationTeacherList1 = examinationTeacherList.stream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(o -> o.getSubjectId() + ";" + o.getClazzId())
                )), ArrayList::new)
        );
        Boolean isTeacherInsert = DateUtil.getTimeCompare(examination.getStartTime(), examination.getFinishTime(), examinationTeacherList1);

        //1.判断该班级是否考过此科目
        if ((numberExamination1.size() == 0) && (numberExamination2.size() == 0)) {
            // 判断该班级同时间是否还有其他考试
            if (isClazzInsert) {
                if (isTeacherInsert) {
                    //遍历学生id
                    assert studentIds != null;
                    for (String studentId : studentIds) {
                        Examination examination1 = Examination.builder()
                                //查询所有学期下拉框选择学期
                                .semester(examination.getSemester())
                                //查询所有学科下拉框选择科目（模糊查询）
                                .subjectId(examination.getSubjectId())
                                //查询所有老师下拉框选择老师（模糊查询）
                                .teacherName(examination.getTeacherName())
                                .teacherId(examination.getTeacherId())
                                .type(examination.getType())
                                //考试开始时间
                                .startTime(examination.getStartTime())
                                //考试结束时间
                                .finishTime(examination.getFinishTime())
                                //查询楼栋、房间名
                                .area(examination.getArea())
                                //考试总分
                                .score(examination.getScore())
                                //下拉框查询所有班级（模糊查询）
                                .clazzId(examination.getClazzId())
                                .isJoin(false)
                                .jobNumber(studentId)
                                .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                                .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                                .isDeleted(false)
                                .build();
                        examinationList.add(examination1);
                    }
                    examinationRepository.saveAll(examinationList);
                    return ResponseResult.success("新增考务成功");
                } else {
                    return ResponseResult.failure(ResultCode.TEACHER_EXAMINATION_REPETITION);
                }

            } else {
                return ResponseResult.failure(ResultCode.STUDENT_EXAMINATION_REPETITION);
            }

        } else {
            return ResponseResult.failure(ResultCode.EXAMINATION_REPETITION);
        }

    }


    @Override
    public List<EntityVo> findAllByPage(PageDto pageDto) {
        // 第一步：调用底层 Repository 中的分页查询方法，返回结果为 List<Object> 对象
        List<Object> examinationVos = examinationRepository.selectAll(pageDto);
        // 第二步：调用工具类，处理 List<Object> 对象
        return DataTypeChange.changeObj(examinationVos, ExaminationVo.class);
    }

    @Override
    public Long countNum() {
        return examinationRepository.count();
    }


}
