package cn.wolfcode.luowowo.hotel.service;

import cn.wolfcode.luowowo.hotel.domain.HotelTheme;

import java.util.List;

public interface IHotelThemeServie {
    /**
     * 随机查询主题库中排前面的六个主题
     * @return
     */
    List<HotelTheme> queryHotelThemeOnly6();

    /**
     * 根据住宿主题id,查询主题
     * @param themeId
     * @return
     */
    HotelTheme getHotelTheme(long themeId);

    /**
     * 查询目的地下酒店主题
     * @param destId
     * @return
     */
    List<HotelTheme> queryHotelThemeOnly6ByDestId(Long destId);
}
