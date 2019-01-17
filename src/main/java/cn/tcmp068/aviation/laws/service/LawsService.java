package cn.tcmp068.aviation.laws.service;

import cn.tcmp068.aviation.entity.Laws;
import com.github.pagehelper.PageInfo;

public interface LawsService {
    PageInfo<Laws> queryAll(Laws laws, int pageNumber, int pageSize);//查所有
    int addLaws( Laws laws);//增加
}
