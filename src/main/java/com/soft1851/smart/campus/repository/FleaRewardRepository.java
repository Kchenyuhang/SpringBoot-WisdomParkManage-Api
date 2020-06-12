
package com.soft1851.smart.campus.repository;

import com.soft1851.smart.campus.model.entity.FleaReward;
import com.soft1851.smart.campus.model.vo.RewardVo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author 倪涛涛
 * @version 1.0.0
 * @ClassName a.java
 * @Description TODO
 * @createTime 2020年06月09日 11:26:00
 */
public interface FleaRewardRepository extends JpaRepository<FleaReward, Long> {
    List<FleaReward> findFleaRewardsByDescriptionLikeOrTitleLike(String description, String title);

    /**
     * 根据创建时间查出前两条数据
     *
     * @param pageable
     * @return
     */
    @Query(value = "select new com.soft1851.smart.campus.model.vo.RewardVo(f.title,f.description,f.imageUrl,f.createTime,u.username,u.phoneNumber) " +
            "from FleaReward f " +
            "left join f.fleaUser u")
    List<RewardVo> getTopReward(Pageable pageable);

    FleaReward findFleaRewardByPkRewardIdEquals(Long pkRewardId);
}
