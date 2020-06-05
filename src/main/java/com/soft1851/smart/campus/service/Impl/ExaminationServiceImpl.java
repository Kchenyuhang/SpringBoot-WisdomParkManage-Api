package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.Examination;
import com.soft1851.smart.campus.model.vo.ExaminationVo;
import com.soft1851.smart.campus.repository.ExaminationRepository;
import com.soft1851.smart.campus.service.ExaminationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void updateInfo(Examination examination) {
        createDate(examination);
        examinationRepository.updateInfo(examination);
    }

    @Override
    public void increaseInfo(Examination examination) {
        createDate(examination);
        examinationRepository.saveAndFlush(examination);
    }

    @Override
    public List<ExaminationVo> findAllByPage(PageDto pageDto) {
        // 第一步：调用底层 Repository 中的分页查询方法，返回结果为 List<Object> 对象
        List<Object> examinationVos = examinationRepository.selectAll(pageDto);
        // 第二步：创建 List<ExaminationVo> 对象作为将来的返回结果
        List<ExaminationVo> list = new ArrayList<>(10);
        // 第三步：遍历 List<Object> 对象，此对象中的具体值，请看本项目根路径下的 ‘object.json’文件，已经处理成 JSON 数据
        for (Object obj : examinationVos) {
            Object[] rowArray = (Object[]) obj;
            /*
             第四步：依次将 rowArray 中的数据拿出来转换为 Java中的对象，并复制给我们的 examinationVo 对象
             此处需要注意 Object 转 Long的方法，不能直接强制类型转换
             */
            ExaminationVo examinationVo = ExaminationVo.builder()
                    .pkExaminationId(Long.valueOf(String.valueOf(rowArray[0])))
                    .semester((String) rowArray[1])
                    .teacherName((String) rowArray[2])
                    .startTime((Timestamp) rowArray[3])
                    .area((String) rowArray[4])
                    .score((Integer) rowArray[5])
                    .type((String) rowArray[6])
                    .gmtCreate((Timestamp) rowArray[7])
                    .subjectName((String) rowArray[8])
                    .clazzName((String) rowArray[9])
                    .build();
            list.add(examinationVo);
        }
        return list;
    }

    @Override
    public Long countNum() {
        return examinationRepository.count();
    }

    /**
     * 为 examination对象补充属性值的方法
     *
     * @param examination
     */
    private void createDate(Examination examination) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (examination.getGmtCreate() == null) {
            examination.setGmtCreate(timestamp);
        }
        if (examination.getGmtModified() == null) {
            examination.setGmtModified(timestamp);
        }
        examination.setIsDeleted(false);
    }
}
