package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GoodsMapper {
    @Select("SELECT good_id,name,price,img FROM Goods")
    Goods browseAll();
    /*sql语句多表查询*/
    @Select("SELECT name,price,img,restname,describe FROM Goods WHERE good_id =#{good_id}")
    Goods browseOne1(@Param("good_id") int good_id);
    @Select("SELECT Shop.name FROM Goods,Shop WHERE Goods.good_id=#{good_id} AND Shop.shop_id=Goods.shop_id")
    String browseOne2(@Param("good_id") int good_id);
    @Select("SELECT good_id,name,price,img FROM Goods WHERE shop_id =#{shop_id}")
    Goods browseShop(@Param("shop_id") int shop_id);
    @Select("SELECT good_id,name,img FROM Goods WHERE name like '%key%'")
    Goods findAll(@Param("key") String key);
    @Select("SELECT good_id,name,img FROM Goods WHERE name like '%key%' WHERE shop_id =#{shop_id}")
    Goods findShop(@Param("shop_id") int shop_id, @Param("key") String key);
    @Insert("INSERT INTO Shop(name,price,status,shop_id,type_id,img,restnum,totalnum,describe) VALUES(#{name},#{price},#{status},#{shop_id},#{type_id},#{img},#{totalnum},#{totalnum},#{describe})")
    boolean add(Goods goods);
    @Delete("DELETE FROM Goods WHERE good_id =#{good_id}")
    boolean delete(@Param("good_id") int good_id);
    @Update("UPDATE Goods set name=#{name},price=#{price},status=#{status},img=#{img},set describe=#{describe} WHERE good_id =#{good_id}")
    boolean update(Goods goods);
    @Select("")
    int salenum(@Param("good_id") int good_id);
}
