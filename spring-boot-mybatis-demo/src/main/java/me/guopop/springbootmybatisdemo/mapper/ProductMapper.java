package me.guopop.springbootmybatisdemo.mapper;

import me.guopop.springbootmybatisdemo.entity.Product;

/**
 * @author guopop
 * @date 2021/3/20 11:22
 */
public interface ProductMapper {

    Product findById(Long id);
}
