package me.guopop.springbootmybatisdemo.service;

import me.guopop.springbootmybatisdemo.entity.Product;
import me.guopop.springbootmybatisdemo.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author guopop
 * @date 2021/3/20 11:34
 */
@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product findById(Long id) {
        return productMapper.findById(id);
    }
}
