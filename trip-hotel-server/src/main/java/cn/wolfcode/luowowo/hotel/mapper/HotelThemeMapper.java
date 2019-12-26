package cn.wolfcode.luowowo.hotel.mapper;

import cn.wolfcode.luowowo.hotel.domain.HotelTheme;
import java.util.List;

public interface HotelThemeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelTheme record);

    HotelTheme selectByPrimaryKey(Long id);

    List<HotelTheme> selectAll();

    int updateByPrimaryKey(HotelTheme record);

    /**
     * 随机查询主题库中排前面的六个主题
     * @return
     */
    List<HotelTheme> selectHotelThemeOnly6();

}