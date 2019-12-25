package cn.wolfcode.luowowo.article.service;

import cn.wolfcode.luowowo.article.domain.TravelContent;

public interface ITravelContentService {
    /**
     * 根据id查内容
     * @param id
     * @return
     */
    TravelContent getById(Long id);
}
