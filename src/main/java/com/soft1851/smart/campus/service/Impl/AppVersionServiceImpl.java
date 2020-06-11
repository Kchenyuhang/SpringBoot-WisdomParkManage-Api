package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.constant.ResponseResult;
import com.soft1851.smart.campus.constant.ResultCode;
import com.soft1851.smart.campus.model.dto.PageDto;
import com.soft1851.smart.campus.model.entity.AppVersion;
import com.soft1851.smart.campus.repository.AppVersionRepository;
import com.soft1851.smart.campus.service.AppVersionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName AppVersionServiceImpl
 * @Description TODO
 * @date 2020-06-03 8:15
 **/
@Service
@Transactional(rollbackOn =Exception.class )
public class AppVersionServiceImpl implements AppVersionService {
    @Resource
    private AppVersionRepository appVersionRepository;

    /**
     * 分页查询所有版本号
     *
     * @param pageDto
     * @return
     */
    @Override
    public ResponseResult findAllAppVersion(PageDto pageDto) {
        Pageable pageable = PageRequest.of(
                pageDto.getCurrentPage(),
                pageDto.getPageSize(),
                Sort.Direction.ASC,
                "pkAppVersionId");
        Page<AppVersion> appVersions = appVersionRepository.findAll(pageable);
        return ResponseResult.success(appVersions.getContent());
    }

    /**
     * 新增版本
     *
     * @param appVersion
     * @return
     */
    @Override
    public ResponseResult increaseAppVersion(AppVersion appVersion) {
        //查找最低版本号
        AppVersion minAppVersion = appVersionRepository.findTopByOrderByPkAppVersionIdAsc();
        //查询所有版本id 进行批量修改的操作
        List<Long> ids = appVersionRepository.selectAllPkAppVersionId();
        appVersionRepository.updateMaxVersion(appVersion.getCurrentVersion(), ids);
        //判断数据是否完整
        boolean isAppType = appVersion.getAppType() != null;
        boolean isCurrent = appVersion.getCurrentVersion() != null;
        boolean isDescription = appVersion.getVersionDescription() != null;
        boolean isDownloadLink = appVersion.getDownloadLink() != null;
        //数据信息完整进行新增版本信息
        if (isAppType && isCurrent && isDescription && isDownloadLink) {
            AppVersion appVersion1 = AppVersion.builder()
                    .appType(appVersion.getAppType())
                    .currentVersion(appVersion.getCurrentVersion())
                    .maxVersion(appVersion.getCurrentVersion())
                    .minVersion(minAppVersion.getMinVersion())
                    .versionDescription(appVersion.getVersionDescription())
                    .downloadLink(appVersion.getDownloadLink())
                    .gmtCreate(Timestamp.valueOf(LocalDateTime.now()))
                    .gmtModified(Timestamp.valueOf(LocalDateTime.now()))
                    .isDeleted(false)
                    .build();
            appVersionRepository.save(appVersion1);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.PARAM_NOT_COMPLETE);
        }
    }

    /**
     * 修改版本数据
     *
     * @param appVersion
     * @return
     */
    @Override
    public ResponseResult modificationAppVersion(AppVersion appVersion) {
        //查询出
        AppVersion appVersion1 = appVersionRepository.findAppVersionByPkAppVersionId(appVersion.getPkAppVersionId());
        if (appVersion1 != null) {
            appVersion1.setAppType(appVersion.getAppType());
            appVersion1.setDownloadLink(appVersion.getDownloadLink());
            appVersion1.setVersionDescription(appVersion.getVersionDescription());
            appVersion1.setCurrentVersion(appVersion.getCurrentVersion());
        }
        return null;
    }

    /**
     * 单个删除
     *
     * @param id
     * @return
     */
    @Override
    public ResponseResult deletionAppVersion(Long id) {
        //需要删除的APP版本号
        AppVersion appVersion = appVersionRepository.findAppVersionByPkAppVersionId(id);
        //查询最高版本的数据
        AppVersion maxAppVersion = appVersionRepository.findTopByOrderByPkAppVersionIdDesc();
        //查询最低版本的数据
        AppVersion minAppVersion = appVersionRepository.findTopByOrderByPkAppVersionIdAsc();
        //判断数据存在
        if (appVersion != null) {
            //判断即将被删除的APP版本的数据是否为最高版本的数据
            if ((appVersion.getCurrentVersion()).equals(maxAppVersion.getCurrentVersion())) {
                //当前删除的为最高版本数据
                appVersionRepository.deleteByPkAppVersionId(id);
                //修改其他所有版本数据的最高版本号
                AppVersion updateMaxAppVersion = appVersionRepository.findTopByOrderByPkAppVersionIdDesc();
                List<Long> ids = appVersionRepository.selectAllPkAppVersionId();
                appVersionRepository.updateMaxVersion(updateMaxAppVersion.getCurrentVersion(), ids);
                return ResponseResult.success();
                //判断即将被删除的APP版本号是否为最低版本号
            } else if ((appVersion.getCurrentVersion()).equals(minAppVersion.getCurrentVersion())) {
                //当前删除的为最高版本数据
                appVersionRepository.deleteByPkAppVersionId(id);
                //修改其他所有版本数据的最低版本号
                AppVersion updateMinAppVersion = appVersionRepository.findTopByOrderByPkAppVersionIdAsc();
                List<Long> ids = appVersionRepository.selectAllPkAppVersionId();
                appVersionRepository.updateMinVersion(updateMinAppVersion.getCurrentVersion(), ids);
                return ResponseResult.success();
            } else {
                //即将删除的数据既不是最高版本号也不是最低版本号
                appVersionRepository.deleteByPkAppVersionId(id);
                return ResponseResult.success();
            }
        } else {
            return ResponseResult.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseResult deletedBatch(String ids) {
        //判断是否有数据
        if (ids.length() != 0) {
            //将接收到的ids字符串，使用逗号分割
            String[] idArr = ids.split(",");
            List<Long> idsList = new ArrayList<Long>();
            for (String id : idArr) {
                //遍历所有id存入到list
                idsList.add(Long.valueOf(id));
            }
            appVersionRepository.deleteBatch(idsList);
            //批量删除完成后 查询目前的最高版本号和最低版本号
            AppVersion maxAppVersion = appVersionRepository.findTopByOrderByPkAppVersionIdDesc();
            AppVersion minAppVersion = appVersionRepository.findTopByOrderByPkAppVersionIdAsc();
            List<Long> versionIds = appVersionRepository.selectAllPkAppVersionId();
            //修改最高最低的版本所有数据
            appVersionRepository.updateMinVersion(minAppVersion.getCurrentVersion(), versionIds);
            appVersionRepository.updateMaxVersion(maxAppVersion.getCurrentVersion(), versionIds);
            return ResponseResult.success();
        } else {
            return ResponseResult.failure(ResultCode.PARAM_IS_BLANK);
        }
    }
}
