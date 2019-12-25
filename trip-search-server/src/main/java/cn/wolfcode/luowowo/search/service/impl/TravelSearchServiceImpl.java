package cn.wolfcode.luowowo.search.service.impl;

import cn.wolfcode.luowowo.search.domain.TravelTemplate;
import cn.wolfcode.luowowo.search.repository.TravelTemplateRepository;
import cn.wolfcode.luowowo.search.service.ITravelSearchService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.List;

@Service
public class TravelSearchServiceImpl implements ITravelSearchService {

    //es 依然使用spring-data-jpa

    //repository 封装了template
    //template 封装了 client

    @Autowired
    private TravelTemplateRepository repository;
    @Autowired
    private ElasticsearchTemplate template;


    @Override
    public void save(TravelTemplate tt) {
        repository.save(tt);
    }

    @Override
    public List<TravelTemplate> selectByDestName(String destName) {

        return repository.findByDestName(destName);
    }
}
