package cn.wolfcode.luowowo.article.service.impl;

import cn.wolfcode.luowowo.article.domain.AirTicket;
import cn.wolfcode.luowowo.article.mapper.AirTicketMapper;
import cn.wolfcode.luowowo.article.service.IAirTicketService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AirTicketServiceImpl implements IAirTicketService{
    @Autowired
    private AirTicketMapper airTicketMapper;


    @Override
    public List<AirTicket> getStartSiteByIshot(String[] arr) {
        List<AirTicket> airTickets = airTicketMapper.selectStartSiteByIshot();
        // 定义一个容器
        List<String> cities = new ArrayList<>();
        // 遍历城市,把城市放到容器中, 如果容器中存在该城市, 则移除
        for(int i = 0; i < airTickets.size(); i++){
            if (cities.contains(airTickets.get(i).getArriveCity().getName())){
                airTickets.remove(i);
                i--;
            }
            cities.add(airTickets.get(i).getArriveCity().getName());
        }

        // 拼音首字母对应的城市
        if (arr != null && arr.length > 0){
            List<AirTicket> airTicketsCities = new ArrayList<>();
            for(int i = 0; i < airTickets.size(); i++){
                String pinyin = airTickets.get(i).getStartCity().getPinyin();
                for (String letter : arr) {
                    if (pinyin.startsWith(letter)){
                        airTicketsCities.add(airTickets.get(i));
                    }
                }
            }
            return airTicketsCities;
        }

        return airTickets;
    }

    @Override
    public List<AirTicket> search(String orgCity, String dstCity, String depTime) {
        return airTicketMapper.search(orgCity, dstCity, depTime);
    }

    @Override
    public AirTicket selectById(int id) {
        return airTicketMapper.selectById(id);
    }

   /* @Override
    public List<AirTicket> selectByIds(List<Long> ids) {
        return airTicketMapper.selectByIds(ids);
    }*/
}
