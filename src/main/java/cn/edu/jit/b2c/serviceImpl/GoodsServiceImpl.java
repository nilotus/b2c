package cn.edu.jit.b2c.serviceImpl;

import cn.edu.jit.b2c.mapper.GoodsMapper;
import cn.edu.jit.b2c.pojo.Goods;
import cn.edu.jit.b2c.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public String goods(String img) {
        Goods goods = goodsMapper.findImg(img);
        return goods.getGood_id()+" "+goods.getShop_id()+" "+goods.getName()+" "+goods.getPrice()+" "+goods.getRestnum()
                +" "+goods.getTotalnum()+" "+goods.getStatus()+" "+goods.getImg();
    }
}
