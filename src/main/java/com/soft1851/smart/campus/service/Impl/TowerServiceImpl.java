package com.soft1851.smart.campus.service.Impl;

import com.soft1851.smart.campus.model.entity.Tower;
import com.soft1851.smart.campus.repository.TowerRepository;
import com.soft1851.smart.campus.service.TowerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/6/1
 * @Version 1.0
 */
@Service
public class TowerServiceImpl implements TowerService {
    @Resource
    private TowerRepository towerRepository;

    @Override
    public List<Tower> findAll() {
        return towerRepository.findAll();
    }

    @Override
    public void insertTower(Tower tower) {
        tower.setGmtCreate(Timestamp.valueOf(LocalDateTime.now()));
        tower.setIsDeleted(false);
        towerRepository.save(tower);
    }

    @Override
    public void deleteTowerById(long towerId) {
        towerRepository.deleteById(towerId);
    }

    @Override
    public void updateTowerByTowerId(Tower tower) {
        towerRepository.updateTowerByTowerId(tower);
    }
}
