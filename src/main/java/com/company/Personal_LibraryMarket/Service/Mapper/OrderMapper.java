//Allohim ilmimni ziyoda qilgin!!

package com.company.Personal_LibraryMarket.Service.Mapper;

import com.company.Personal_LibraryMarket.Dto.OrderDto;
import com.company.Personal_LibraryMarket.Model.Order;
import com.company.Personal_LibraryMarket.Service.UserService;
import org.aspectj.weaver.ast.Or;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class OrderMapper {
    @Autowired
    protected UserService userService;

    @Autowired
    protected UserMapper userMapper;

    //target -> return type
    //source -> param

    @Mapping(target = "user", source = "users")
    public abstract Order toEntity(OrderDto dto);

    @Mapping(target = "users", expression = "java(userMapper.toDtoNotOrder(order.getUser()))")
    public abstract OrderDto toDtoForGetMethod(Order order);

    @Mapping(target = "users", expression = "java(userMapper.toDtoNotOrder(userMapper.toEntity(userService.getUser(order.getUserId()).getData())))")
    public abstract OrderDto toDtoForPostMethod(Order order);

    /*public void viewMethod(){
        Order order  = new Order();
        OrderDto orderDto = new OrderDto();
        orderDto.setUsers(userMapper.toDtoNotOrder(userMapper.toEntity(userService.getUser(order.getUserId()).getData())));
    }*/
}
