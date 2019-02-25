package com.imooc.redis.controller;

import com.imooc.redis.entity.City;
import com.imooc.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CityController {

    @Autowired
    private RedisService redisService;


    //http://localhost:33000/saveCity?cityName=北京&cityIntroduce=中国首都&cityId=1
    @RequestMapping("/saveCity")
    public String saveCity(int cityId,String cityName,String cityIntroduce){
        City city = new City(cityId,cityName,cityIntroduce);
        redisService.set(cityId+"",city);
        return "success";
    }



    //http://localhost:33000/getCityById?cityId=1
    @RequestMapping("/getCityById")
    public City getCity(int cityId){
        City city = (City) redisService.get(cityId+"");
        return city;
    }
}
