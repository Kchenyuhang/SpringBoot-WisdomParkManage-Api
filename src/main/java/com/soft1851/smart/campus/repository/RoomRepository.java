package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.Room;
import com.soft1851.smart.campus.model.vo.TowerVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author xunmi
 * @ClassName RoomRepository
 * @Description 房间管理相关操作的类
 * @Date 2020/5/29
 * @Version 1.0
 **/
public interface RoomRepository extends JpaRepository<Room, Long> {

    /**
     * 通过房间 id 查找出房间名
     *
     * @param id
     * @return
     */
    @Query(value = "SELECT name FROM room WHERE id = ?1", nativeQuery = true)
    String getRoomName(Long id);

    /**
     * 查询所有房间信息
     * @return
     */
    @Query(value = "SELECT NEW com.soft1851.smart.campus.model.vo.TowerVo (r.id, r.name, t.name, u.name, r.gmtCreate, r.electricityBalance) " +
            "FROM Room r " +
            "LEFT JOIN Tower t " +
            "ON r.towerId = t.pkTowerId " +
            "LEFT JOIN TowerUnit u " +
            "ON r.unitId = u.unitId " +
            "ORDER BY r.gmtCreate ")
    List<TowerVo> selectAll();

    /**
     * 根据id修改房间信息
     * @param room
     */
    @Query(value = "UPDATE Room SET name=:#{#room.name}, towerId=:#{#room.towerId}, unitId=:#{#room.unitId} WHERE id=:#{#room.id}")
    void updateRoomById(@Param("room") Room room);
}
