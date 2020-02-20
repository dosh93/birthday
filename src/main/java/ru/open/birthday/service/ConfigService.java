package ru.open.birthday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.open.birthday.entity.Config;
import ru.open.birthday.repository.ConfigRepository;

import java.util.List;

@Service
public class ConfigService {

    @Autowired
    private final ConfigRepository configRepository;

    public ConfigService(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    public String getValueByKey(String key){
        return configRepository.findById(key).get().getValue();
    }

    public void save(Config config){
        configRepository.save(config);
    }

    public List<Config> getAll(){
        return configRepository.findAll();
    }

    public Config getByKey(String key){
        return configRepository.findById(key).get();
    }


}
