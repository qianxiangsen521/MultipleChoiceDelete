/*
 * Copyright 2016 jeasonlzy(廖子尧)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.selectanddelete.entity;

import java.util.List;

/**
 * @author qianxiangsen
 */
public class SimpleResponse extends BaseResponse {


    /**
     * resultCode : 1
     * resultMsg : 读取成功
     * ResultTotal : 141588
     * resultList : [{"title":"美向亚太派第二个航母战斗群","vtype":"0","duration":"72","make_user_id":"许真","cp":"央广视讯","seq_id":"20140825000982","check_status":"0","check_user_id":"","check_memo":null},{"title":"那没有煽情诉说的《担心》","vtype":"0","duration":"245","make_user_id":"申子文","cp":"海蝶文化","seq_id":"20141031011272","check_status":"0","check_user_id":"","check_memo":null},{"title":"华润审计总监黄道国违法被查","vtype":"0","duration":"84","make_user_id":"许真","cp":"央广视讯","seq_id":"20140825000981","check_status":"0","check_user_id":"","check_memo":null},{"title":"钟镇涛大婚豪掷530万狂欢","vtype":"0","duration":"80","make_user_id":"许真","cp":"央广视讯","seq_id":"20140825000980","check_status":"0","check_user_id":"","check_memo":null},{"title":"2014港姐十强出炉美丽动人","vtype":"0","duration":"76","make_user_id":"许真","cp":"央广视讯","seq_id":"20140825000979","check_status":"0","check_user_id":"","check_memo":null},{"title":"郭敬明微博疑回应换角传闻","vtype":"0","duration":"76","make_user_id":"许真","cp":"央广视讯","seq_id":"20140825000978","check_status":"0","check_user_id":"","check_memo":null},{"title":"朱芳雨同神秘女亲密照曝光","vtype":"0","duration":"75","make_user_id":"","cp":"央广视讯","seq_id":"20140824000977","check_status":"0","check_user_id":"","check_memo":null},{"title":"16位候选港姐泳装现身彩排","vtype":"0","duration":"69","make_user_id":"","cp":"央广视讯","seq_id":"20140824000976","check_status":"0","check_user_id":"","check_memo":null},{"title":"科比可争历史最佳36岁侧翼","vtype":"0","duration":"83","make_user_id":"","cp":"央广视讯","seq_id":"20140824000975","check_status":"0","check_user_id":"","check_memo":null},{"title":"安吉丽娜朱莉被曝性欲高涨","vtype":"0","duration":"71","make_user_id":"","cp":"央广视讯","seq_id":"20140824000974","check_status":"0","check_user_id":"","check_memo":null},{"title":"范玮琪结婚三年喜怀双胞胎","vtype":"0","duration":"82","make_user_id":"","cp":"央广视讯","seq_id":"20140824000973","check_status":"0","check_user_id":"","check_memo":null},{"title":"爸爸2姐姐大哭道歉疑退出","vtype":"0","duration":"67","make_user_id":"","cp":"央广视讯","seq_id":"20140824000972","check_status":"0","check_user_id":"","check_memo":null},{"title":"爸爸2姐姐大哭道歉疑退出","vtype":"0","duration":"67","make_user_id":"","cp":"央广视讯","seq_id":"20140824000971","check_status":"0","check_user_id":"","check_memo":null},{"title":"柯震东被除名郭敬明遭围攻","vtype":"0","duration":"75","make_user_id":"","cp":"央广视讯","seq_id":"20140824000970","check_status":"0","check_user_id":"","check_memo":null},{"title":"Hebe自曝全裸迎冰桶挑战","vtype":"0","duration":"83","make_user_id":"","cp":"央广视讯","seq_id":"20140824000969","check_status":"0","check_user_id":"","check_memo":null},{"title":"林凤娇青涩照曝光美艳动人","vtype":"0","duration":"83","make_user_id":"","cp":"央广视讯","seq_id":"20140824000968","check_status":"0","check_user_id":"","check_memo":null},{"title":"女星扮泫雅与男星火辣互摸","vtype":"0","duration":"74","make_user_id":"","cp":"央广视讯","seq_id":"20140824000967","check_status":"0","check_user_id":"","check_memo":null},{"title":"习近平观看那达慕弯弓搭箭","vtype":"0","duration":"101","make_user_id":"","cp":"央广视讯","seq_id":"20140824000963","check_status":"0","check_user_id":"","check_memo":null},{"title":"代课老师性侵小学生被判刑","vtype":"0","duration":"84","make_user_id":"","cp":"央广视讯","seq_id":"20140824000960","check_status":"0","check_user_id":"","check_memo":null},{"title":"港新生代女星被曝涉吸毒案","vtype":"0","duration":"77","make_user_id":"","cp":"央广视讯","seq_id":"20140824000958","check_status":"0","check_user_id":"","check_memo":null}]
     */

    private List<ResultListBean> resultList;


    public List<ResultListBean> getResultList() {
        return resultList;
    }

    public void setResultList(List<ResultListBean> resultList) {
        this.resultList = resultList;
    }


}
