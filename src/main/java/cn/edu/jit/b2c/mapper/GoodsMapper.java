package cn.edu.jit.b2c.mapper;

import cn.edu.jit.b2c.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsMapper {
    @Select("SELECT good_id,shop_id,name,price,img FROM Goods")
    List<Goods> browseAll();
    /*sql语句多表查询*/
    @Select("SELECT good_id,`name`,type_id,status,price,img,restnum,totalnum,`describe` FROM Goods WHERE good_id =#{good_id}")
    List<Goods> selectGoodInfo(@Param("good_id") int good_id);
    @Select("SELECT Goods.good_id,Shop.name AS shopname,Goods.name,Goods.price,Goods.img,Goods.`describe`  FROM Goods,Shop WHERE good_id =#{good_id} AND Goods.shop_id = Shop.shop_id" )
    Goods browseOne1(@Param("good_id") int good_id);
    @Select("SELECT Shop.name FROM Goods,Shop WHERE good_id =#{good_id} AND Goods.shop_id = Shop.shop_id" )
    String selectGoodsShop(@Param("good_id") int good_id);
    @Select("SELECT Shop.name FROM Goods,Shop WHERE Goods.good_id=#{good_id} AND Shop.shop_id=Goods.shop_id")
    String browseOne2(@Param("good_id") int good_id);
    @Select("SELECT * FROM Goods WHERE shop_id =#{shop_id}")
    List<Goods> browseShop(@Param("shop_id") int shop_id);
    @Select("SELECT good_id,shop_id,`name`,price,img FROM Goods WHERE name like CONCAT(CONCAT('%', #{key}), '%')")
    List<Goods> findAll(@Param("key") String key);
    @Select("SELECT good_id,shop_id,name,price,img FROM Goods WHERE name like '%${key}%' AND shop_id =#{shop_id}")
    List<Goods> findShop(@Param("shop_id") int shop_id, @Param("key") String key);
    @Insert("INSERT INTO Goods(`name`,`price`,status,shop_id,type_id,img,restnum,totalnum,`describe`) VALUES(#{name},#{price},#{status},#{shop_id},#{type_id},#{img},#{totalnum},#{totalnum},#{describe})")
    boolean add(Goods goods);
    @Delete("DELETE FROM Goods WHERE good_id =#{good_id}")
    boolean delete(@Param("good_id") int good_id);
    @Update("UPDATE Goods set `name`=#{name},`price`=#{price},`status`=#{status},img=#{img},`describe`=#{describe},type_id=#{type_id},restnum=#{restnum},totalnum=#{totalnum} WHERE good_id =#{good_id}")
    boolean update(Goods goods);
    @Select("SELECT restnum,totalnum FROM GOODS WHERE good_id =#{good_id}")
    Goods salenum(@Param("good_id") int good_id);
    @Select("SELECT good_id,shop_id,name,price,img FROM Goods WHERE type_id =#{type_id}")
    List<Goods> browseType(@Param("type_id") int type_id);

}
