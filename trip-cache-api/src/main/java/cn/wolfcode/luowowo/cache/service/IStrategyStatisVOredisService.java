package cn.wolfcode.luowowo.cache.service;

import cn.wolfcode.luowowo.article.domain.StrategyCommend;
import cn.wolfcode.luowowo.cache.domain.StrategyStatisVO;
import cn.wolfcode.luowowo.member.domain.UserInfo;

import java.util.List;

/**
 * 数据统计缓存服务接口
 */
public interface IStrategyStatisVOredisService {
    /**
     * 阅读数增加
     * @param id
     * @param userInfo
     * @return
     */
    StrategyStatisVO viewnumIncrease(Long id, int increase, UserInfo userInfo);

    /**
     * 评论数加上increase
     * @param detailId
     * @param increase
     */
    StrategyStatisVO replynumIncrease(Long detailId, int increase);

    /**
     * 收藏与取消
     * @param sid
     * @param userInfo
     */
    boolean favor(Long sid, UserInfo userInfo);

    /**
     * 查询用户是否收藏攻略
     * @param strategyID
     * @param userId
     * @return
     */
    boolean selectISFavorByUId(Long strategyID, Long userId);

    /**
     * 查vo
     * @param sid
     * @return
     */
    StrategyStatisVO selectStrategyStatisVOById(Long sid);

    /**
     * 攻略置顶(点赞)操作
     * @param sid
     * @param uid
     * @return
     */
    boolean Thumbup(Long sid, Long uid);

    /**
     * 查询指定vo是否存在
     * @param id
     * @return
     */
    boolean isExist(Long id);

    /**
     * (添加)初始化数据
     * @param vo
     */
    void save(StrategyStatisVO vo);

    /**
     * 获取所有vo对象
     * @return
     */
    List<StrategyStatisVO> listAll();

    /**
     * 热门攻略top
     * @param num
     * @return
     */
    List<StrategyStatisVO> hotCDsTop(int num);

    /**
     * 热门攻略热度+num
     * @param id
     * @param num
     */
    void addHotScore(Long id, int num);

    /**
     * 国内外攻略推荐+num
     * @param sid
     * @param num
     */
    void addCommendScore(Long sid, int num);

    /**
     * 国内外攻略top
     * @return
     */
    List<StrategyStatisVO> queryCommendList();

    /**
     * 查询zetset是否存在不指定value
     * @param prefix
     * @param value
     * @return
     */
    boolean isZsetHasValue(String prefix, String value);

    /**
     * 往热门区域zset中加分数
     * @param value
     * @param score
     */
    void addHotScores(String value, int score);

    /**
     * 往国内外区域zset加分数
     * @param value
     * @param score
     */
    void addCommendScores(String value, int score);

    /**
     * 保存用户收藏的攻略
     * @param sid
     * @param userId
     */
    void addUserStrategyCoolection(Long sid, Long userId);

    /**
     * 减去指定用户收藏的攻略
     * @param sid
     * @param userId
     */
    void subUserStrategyCoolection(Long sid, Long userId);

    /**
     * 查询用户收藏的攻略
     * @param userId
     * @return
     */
    List<Long> selectUserStrategyCoolection(Long userId);
}
