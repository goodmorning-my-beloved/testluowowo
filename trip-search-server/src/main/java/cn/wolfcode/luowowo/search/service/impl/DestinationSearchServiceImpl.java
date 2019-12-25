package cn.wolfcode.luowowo.search.service.impl;

import cn.wolfcode.luowowo.search.domain.DestinationTemplate;
import cn.wolfcode.luowowo.search.repository.DestinationTemplateRepository;
import cn.wolfcode.luowowo.search.service.IDestinationSearchService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@Service
public class DestinationSearchServiceImpl implements IDestinationSearchService {

    //es 依然使用spring-data-jpa

    //repository 封装了template
    //template 封装了 client

    @Autowired
    private DestinationTemplateRepository repository;
    @Autowired
    private ElasticsearchTemplate template;


    @Override
    public void save(DestinationTemplate tt) {
        repository.save(tt);
    }

    @Override
    public DestinationTemplate getByName(String name) {
        return repository.findByName(name);
    }
}
