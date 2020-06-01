package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
}
