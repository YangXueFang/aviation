package cn.tcmp068.aviation.laws.service;

import cn.tcmp068.aviation.entity.Laws;
import com.github.pagehelper.PageInfo;

public interface LawsService {
    PageInfo<Laws> queryAll(Laws laws, int pageNumber, int pageSize);//查所有
    int addLaws( Laws laws);//增加
    int updateLaws(Laws laws);//修改
    Laws queryLawsById(String lawsId);//根据id查询
    int deleteLawsById(String lawsId);//根据id删除
}
