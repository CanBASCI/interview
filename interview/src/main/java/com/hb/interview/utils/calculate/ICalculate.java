package com.hb.interview.utils.calculate;


import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface ICalculate {
    BigDecimal getPrice(BigDecimal price, String name);
}
