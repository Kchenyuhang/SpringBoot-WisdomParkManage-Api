package com.soft1851.smart.campus.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author wf
 * @version 1.0
 * @ClassName TreeNode
 * @Description TODO
 * @date 2020-05-30
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreeNode {
    private Long pkFleaTypeId;
    private Long parentId;
    private String typeName;
    private String typeCoverUrl;
    private String typeUrl;
    private List<TreeNode> subTypes;


    public TreeNode(Long pkFleaTypeId, Long parentId, String typeName, String typeCoverUrl, String typeUrl) {
        this.pkFleaTypeId = pkFleaTypeId;
        this.parentId = parentId;
        this.typeName = typeName;
        this.typeCoverUrl = typeCoverUrl;
        this.typeUrl = typeUrl;
    }
}
